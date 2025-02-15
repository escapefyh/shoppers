package com.shopcart.mapper;

import com.shopcart.entity.Product;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhangxiang
 * @since 2024-12-23
 */
public interface ProductMapper extends BaseMapper<Product> {

    @Select("SELECT MAX(p_id) FROM product")
    Integer selectMaxId();
}
