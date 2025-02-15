package com.shopcart.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class ChangePasswordRequestVO implements Serializable {
    private Integer userNumber;
    private String oldPassword;
    private String newPassword;
    private String confirmuserPwd;
}