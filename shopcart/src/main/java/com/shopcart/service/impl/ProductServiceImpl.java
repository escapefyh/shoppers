package com.shopcart.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shopcart.entity.Product;
import com.shopcart.mapper.ProductMapper;
import com.shopcart.service.IProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shopcart.vo.ProductAddVo;
import com.shopcart.vo.ProductQueryVo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import java.util.Collections;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;

import org.springframework.util.StringUtils;


/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhangxiang
 * @since 2024-12-23
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements IProductService {
    @Resource
    private ProductMapper productMapper;

    /**
     * 商品展示
     * @param
     * @return
     */
    @Override
    public Page<Product> getProductsPage(int currentPage, int pageSize ,Integer pCategory,String pName) {
        Page<Product> page = new Page<>(currentPage, pageSize);
        QueryWrapper<Product> queryWrapper = new QueryWrapper<>();
        if (pCategory!= null) {
            queryWrapper.eq("p_category", pCategory); // 根据分类字段进行筛选，这里假设分类字段名为category，根据实际情况调
        }
        if (pName!= null &&!pName.isEmpty()) {
            queryWrapper.like("p_name", pName); // 根据商品名称进行模糊搜索，假设商品名称字段为p_name，按实际调整
        }

        return productMapper.selectPage(page, queryWrapper);  // 查询所有商品数据
    }
    /**
     * 商品详细
     * @param
     * @return
     */

    @Override
    public Product getProductById(int productId) {
        return productMapper.selectById(productId); // 直接调用BaseMapper提供的根据ID查询方法
    }

    @Override
    public boolean addProduct(ProductAddVo productAddVo) {
        // 创建新的商品对象
        Product product = new Product();
        product.setPName(productAddVo.getPName());
        product.setPPrice(productAddVo.getPPrice());
        product.setPImage(productAddVo.getPImage());
        product.setPCategory(productAddVo.getPCategory());
        product.setPDescription(productAddVo.getPDescription());
        product.setPQuantity(productAddVo.getPQuantity());
        product.setPStatus(productAddVo.getPStatus());

        // 获取当前商品表中最大ID
        Integer maxId = productMapper.selectMaxId();

        // 设置新商品的ID为最大ID + 1
        product.setPId(maxId + 1);

        // 插入新商品并返回结果
        return productMapper.insert(product) > 0;// 调用MyBatis Plus的insert方法插入数据，插入成功返回的影响行数大于0则表示成功
    }

}
