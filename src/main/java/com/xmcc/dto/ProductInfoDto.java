package com.xmcc.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.xmcc.entity.ProductInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductInfoDto implements Serializable {

    @JsonProperty("id")
    private String productId;

    @JsonProperty("name")
    private String productName;

    @JsonProperty("price")
    private String productPrice;

    @JsonProperty("description")
    private String productDescription;

    /** 小图*/
    @JsonProperty("icon")
    private String productIcon;

    public static ProductInfoDto build(ProductInfo productInfo){
        ProductInfoDto productInfoDto = new ProductInfoDto();

        BeanUtils.copyProperties(productInfo,productInfoDto);

        return productInfoDto;
    }
}
