package com.shopcart.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhangxiang
 * @since 2024-12-25
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "Shopcar对象", description = "")
public class Shopcar implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("user_id")
    @TableId("car_id")
    private String carId;

    @ApiModelProperty("商品id")
    @JsonProperty
    private Integer pId;

    @ApiModelProperty("账号")
    private String userNumber;

    @ApiModelProperty("购物车商品名称")
    private String carName;

    @ApiModelProperty("购物车商品价格")
    private Double carPrice;

    @ApiModelProperty("购物车商品数量")
    private Integer carNumber;

    @ApiModelProperty("购物车商品总价")
    private String carTotal;

    @ApiModelProperty("购物车图片地址")
    private String carImage;

    @ApiModelProperty("商品状态 0未付款 1已付款")
    private Integer carState;
}
