package com.shopcart.vo;


import lombok.Data;

@Data
public class CheckoutVo {
    private String userNumber;
    private int prId;
    private int quantity;
}
