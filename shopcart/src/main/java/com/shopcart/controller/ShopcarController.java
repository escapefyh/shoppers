package com.shopcart.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shopcart.entity.Shopcar;
import com.shopcart.service.IProductService;
import com.shopcart.service.IShopcarService;
import com.shopcart.service.impl.ShopcarServiceImpl;
import com.shopcart.utils.Result;
import com.shopcart.vo.CheckoutVo;
import com.shopcart.vo.ShopCarVo;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhangxiang
 * @since 2024-12-25
 */
@RestController
@RequestMapping("/shopcar")
public class ShopcarController {

    @Resource
    private IShopcarService ShopcarService;

//    加入购物车
   @PostMapping("/save")
    public Result saveToShopcart(@RequestBody Shopcar shopcar){
        boolean saveResult = ShopcarService.saveshopcar(shopcar);
        if (saveResult) {

            return Result.success("插入成功");
        } else {
            return Result.fail();
        }
    }

//    购物车显示页面
    @PostMapping("/show")
    public Result showShopcar(@RequestBody ShopCarVo vo){
        return Result.success(ShopcarService.showShopcar(vo.getUserNumber()));
    }

//    订单显示页面
    @PostMapping("/list")
    public Result showlist(@RequestBody ShopCarVo vo){
        return Result.success(ShopcarService.showlist(vo.getUserNumber()));
    }


//结算
@PostMapping("/checkout")
    public Result checkout(@RequestBody CheckoutVo vo){
       boolean checkoutResult = ShopcarService.checOutcar(vo.getUserNumber(),vo.getPrId(),vo.getQuantity());

        if(checkoutResult){
            return Result.success();
        }else {
            return Result.fail();
        }
    }

}

