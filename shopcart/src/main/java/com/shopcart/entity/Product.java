package com.shopcart.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhangxiang
 * @since 2024-12-23
 */
@Getter
@Setter
@Accessors(chain = true)
@ApiModel(value = "Product对象", description = "")
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("商品id")
    @TableId("p_id")
    private Integer pId;

    @ApiModelProperty("商品名称")
    private String pName;

    @ApiModelProperty("商品价格")
    private Double pPrice;

    @ApiModelProperty("商品图片路径")
    private String pImage;

    @ApiModelProperty("商品类别id")
    private String pCategory;

    @ApiModelProperty("商品具体描述")
    private String pDescription;

    @ApiModelProperty("商品数量")
    private Integer pQuantity;

    @ApiModelProperty("商品状态 0缺货 1待上架 2 在售")
    private Integer pStatus;
}
