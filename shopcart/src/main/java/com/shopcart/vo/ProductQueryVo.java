package com.shopcart.vo;

import lombok.Data;

@Data
public class ProductQueryVo {
    private Integer currentPage;
    private Integer pageSize;
    private Integer pCategory;
    private  String pName;

}
