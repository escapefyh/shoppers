package com.shopcart.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shopcart.entity.Product;
import com.shopcart.entity.Shopcar;
import com.shopcart.entity.User;
import com.shopcart.mapper.ProductMapper;
import com.shopcart.mapper.ShopcarMapper;
import com.shopcart.service.IShopcarService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shopcart.service.IUserService;
import com.shopcart.utils.Result;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhangxiang
 * @since 2024-12-25
 */
@Service
public class ShopcarServiceImpl extends ServiceImpl<ShopcarMapper, Shopcar> implements IShopcarService {

    @Resource
    private  ShopcarMapper Mapper;

    @Resource
    private ProductMapper productMapper;

    /**
     * 加入购物车
     * @param shopcar
     * @return
     */
    public  boolean saveshopcar(Shopcar shopcar) {
        shopcar.setCarState(0);
        int result = Mapper.insert(shopcar);
        return result>0;
    }

    @Override
    public List<Shopcar> showShopcar(String userNumber) {
        QueryWrapper<Shopcar> wrapper = new QueryWrapper<>();
        wrapper.eq("user_number",userNumber);
        wrapper.eq("car_state",0);
        return Mapper.selectList(wrapper);
    }

    @Override
    public List<Shopcar> showlist(String userNumber) {
        QueryWrapper<Shopcar> wrapper = new QueryWrapper<>();
        wrapper.eq("user_number",userNumber);
        wrapper.eq("car_state",1);
        return Mapper.selectList(wrapper);
    }

    @Transactional
    @Override
    public boolean checOutcar(String userNumber, int prId, int quantity) {
        QueryWrapper<Shopcar> wrapper = new QueryWrapper<>();
        UpdateWrapper<Product> updateWrapper = new UpdateWrapper<>();
        wrapper.eq("user_number",userNumber);
        wrapper.eq("car_state",0);
        List<Shopcar> shopcarList = baseMapper.selectList(wrapper);

        if (shopcarList.isEmpty()) {
           return false;
        }
        for (Shopcar shopcar : shopcarList) {
            shopcar.setCarState(1);
            // 更新购物车状态
            baseMapper.updateById(shopcar);
        }
        List<Integer> productIdList = new ArrayList<>();
        // 遍历购物车列表，将每个购物车记录中的商品 id 存储到 productIdList 中
        for (Shopcar shopcar : shopcarList) {
            productIdList.add(shopcar.getPId());
        }
//        updateWrapper.in("product_id",productIdList);
        for (Integer productId : productIdList) {
            updateWrapper.clear();
            updateWrapper.eq("p_id",productId);

            updateWrapper.setSql("p_quantity = p_quantity - 1");

            productMapper.update(updateWrapper);
        }
        return true;


//        query.eq("p_id",prId);
//        Product product = productMapper.selectOne(query);
//        if(product==null){
//            return false;
//        }
//        product.setPQuantity(product.getPQuantity() - quantity);
//        productMapper.updateById(product);
//        return true;
    }

}
