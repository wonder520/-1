package com.xmcc.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@DynamicUpdate
@Table(name = "product_info")
public class ProductInfo {

    @Id
    private String productId;

    private String productName;

    private BigDecimal productPrice;

    private Integer productStock;

    /** 小图*/
    private String productIcon;

    /** 状态,0正常 1下架*/
    private Integer productStatus;

    private Integer categoryType;

    private Date createTime;

    private Date updateTime;

}
