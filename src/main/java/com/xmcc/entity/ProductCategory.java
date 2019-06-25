package com.xmcc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity//表示该类为实体类
@DynamicUpdate//设置为true,表示update对象的时候,生成动态的update语句,如果这个字段的值是null就不会被加入到update语句中
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product_category")
public class ProductCategory implements Serializable {

    @Id//主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)//IDENTITY表示自增:mysql    SEQUENCE:oracle
    private Integer categoryId;

    private String categoryName;

    private Integer categoryType;

    private Date createTime;

    private Date updateTime;
}
