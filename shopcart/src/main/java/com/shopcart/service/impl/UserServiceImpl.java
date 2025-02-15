package com.shopcart.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shopcart.entity.User;
import com.shopcart.mapper.UserMapper;
import com.shopcart.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shopcart.vo.ChangePasswordRequestVO;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhangxiang
 * @since 2024-12-21
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Resource
    private UserMapper mapper;

    @Transactional
    @Override
    public User login(User user) {
        QueryWrapper<User> query = new QueryWrapper<>();
        query.eq("user_number", user.getUserNumber());
        query.eq("user_pwd", user.getUserPwd());

        return mapper.selectOne(query);
    }

    /**
     * 注册
     *
     * @param user
     * @return
     */
    @Transactional
    @Override
    public boolean register(User user) {
        QueryWrapper<User> query = new QueryWrapper<>();
        query.eq("user_number", user.getUserNumber());
        if (mapper.selectCount(query) > 0) {
            return false;
        }

        int insertResult = mapper.insert(user);
        if (insertResult > 0) {
            return true;
        } else {
            return false;
        }

    }

    /**
     * 修改密码
     * @param vo
     * @return
     */
    @Transactional
    @Override
    public boolean changePassword(ChangePasswordRequestVO vo) {
        QueryWrapper<User> query = new QueryWrapper<>();
        query.eq("user_number", vo.getUserNumber());
        User user = mapper.selectOne(query);

        if (user == null) {
            return false;
        }
        if (!user.getUserPwd().equals(vo.getOldPassword())) {
            return false;
        }
        user.setUserPwd(vo.getNewPassword());
        int updateResult = mapper.updateById(user);
        if (updateResult > 0) {
            return true;
        }
        return false;
    }
}