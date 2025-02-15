package com.shopcart.controller;

import com.shopcart.entity.User;
import com.shopcart.service.IUserService;
import com.shopcart.utils.Result;
import com.shopcart.vo.ChangePasswordRequestVO;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhangxiang
 * @since 2024-12-21
 */
@RestController
@RequestMapping("/user")
public class UserController {
    //注入业务类userservice业务类进行登录处理
    @Resource
    private IUserService userService;
    @PostMapping("/login")
    public Result login(User user){
        User loginUser =  userService.login(user);
        if(loginUser == null){
            return Result.fail();
        }
        loginUser.setUserPwd(null);
        return Result.success(loginUser);
    }
    /**
     * 注册
     */
    @PostMapping("/register")
    public Result register(@RequestBody User user){
        boolean registerResult = userService.register(user);
        if (registerResult) {

            return Result.success("注册成功");
        } else {
            return Result.fail();
        }
          }

//          修改密码
    @PutMapping("/change-password")
    public Result changePassword(@RequestBody ChangePasswordRequestVO request) {
        boolean changePasswordResult = userService.changePassword(request);
        if (changePasswordResult) {
            return Result.success("修改密码成功！");
        } else {
            return Result.fail();
        }

    }
}


