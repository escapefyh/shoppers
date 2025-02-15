package com.shopcart.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import java.beans.Transient;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author zhangxiang
 * @since 2024-12-21
 */
@Getter
@Setter
@Accessors(chain = true)
@ApiModel(value = "User对象", description = "")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;



    @ApiModelProperty("账号")
    @TableId("user_number")
    private String userNumber;

    @ApiModelProperty("信息")
    private String userMessage;

    @ApiModelProperty("密码")
    private String userPwd;


//    @ApiModelProperty("确认密码")
//    @TableField("confirm_pwd")
//    private String confirmPassword;

}
