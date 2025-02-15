package com.shopcart.service;

import com.shopcart.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.shopcart.vo.ChangePasswordRequestVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhangxiang
 * @since 2024-12-21
 */
public interface IUserService extends IService<User> {
    /**
     * 登录
     * @param user
     * @return
     */
    User login(User user);

    boolean register(User user);


    boolean changePassword(ChangePasswordRequestVO vo);
}
