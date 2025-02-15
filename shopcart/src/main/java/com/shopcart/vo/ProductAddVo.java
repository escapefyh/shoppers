package com.shopcart.vo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
public class ProductAddVo {
    @JsonProperty
    private String pName;
    @JsonProperty
    private Double pPrice;
    @JsonProperty
    private String pImage;
    @JsonProperty
    private String pCategory;
    @JsonProperty
    private String pDescription;
    @JsonProperty
    private int pQuantity;
    @JsonProperty
    private Integer pStatus;
}
