package com.shopcart.controller;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shopcart.entity.Product;
import com.shopcart.service.IProductService;
import com.shopcart.utils.Result;
import com.shopcart.vo.ProductAddVo;
import com.shopcart.vo.ProductQueryVo;
import com.shopcart.vo.ProductDetailVo;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;



/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhangxiang
 * @since 2024-12-23
 */
@RestController
@RequestMapping("/product")
public class ProductController {
     @Resource IProductService productService;
    /**
     * 商品首页展示操作
     */
    @PostMapping("/show")

    public Page<Product> getProducts(@RequestBody ProductQueryVo queryRequest) {
        return productService.getProductsPage(queryRequest.getCurrentPage(), queryRequest.getPageSize(), queryRequest.getPCategory(),queryRequest.getPName());
    }

    /**
     * 点击商品进入商品详细界面
     * @param vo
     * @return
     */
    @PostMapping("/detail")
    public Product getProduct(@RequestBody ProductDetailVo vo) {

        return productService.getProductById(vo.getPId());
    }

//    添加商品
    @PostMapping("/add")
    public Result addProduct(@RequestBody ProductAddVo productAddVo) {
        System.out.println("Received product data: " + productAddVo);
        boolean result = productService.addProduct(productAddVo);
        if (result) {
            return Result.success();
        } else {
            return Result.fail();
        }
    }
}
