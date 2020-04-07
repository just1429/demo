package com.leyou.item.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "tb_brand")
@Data
@ApiModel(value = "Brand",description = "品牌Brand")
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "id",name = "id")
    private Long id;
    @ApiModelProperty(value = "品牌名称",name = "name")
    private String name;// 品牌名称
    @ApiModelProperty(value = "品牌图片",name = "image")
    private String image;// 品牌图片
    @ApiModelProperty(value = "首字母",name = "letter")
    private Character letter;
}