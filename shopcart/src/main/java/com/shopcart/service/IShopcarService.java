package com.shopcart.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shopcart.entity.Shopcar;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhangxiang
 * @since 2024-12-25
 */
public interface IShopcarService extends IService<Shopcar> {
    boolean saveshopcar(Shopcar shopcar);


    List<Shopcar> showShopcar(String userNumber);

    boolean checOutcar(String userNumber,int prId, int quantity);

    List<Shopcar> showlist(String userNumber);
}
