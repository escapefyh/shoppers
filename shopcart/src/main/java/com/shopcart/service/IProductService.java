package com.shopcart.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shopcart.entity.Product;
import com.baomidou.mybatisplus.extension.service.IService;
import com.shopcart.vo.ProductAddVo;
import com.shopcart.vo.ProductQueryVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhangxiang
 * @since 2024-12-23
 */
public interface IProductService extends IService<Product> {

    Page<Product> getProductsPage(int currentPage, int pageSize,Integer pCategory,String pName);
    public Product getProductById(int productId);

    boolean addProduct(ProductAddVo productAddVo);
}
