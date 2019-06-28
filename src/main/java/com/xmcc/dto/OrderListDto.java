package com.xmcc.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@ApiModel("订单列表实体类")
@AllArgsConstructor
@NoArgsConstructor
public class OrderListDto {


    @NotBlank(message = "订单号不能为空")
    @ApiModelProperty(value = "订单号",dataType = "String")
    private String orderId;

    private String buyerName;

    private String buyerPhone;

    private String buyerAddress;

    private String buyerOpenid;

    private BigDecimal orderAmount;

    private Integer orderStatus;

    private Integer payStatus;

    private String createTime;

    private String updateTime;

    @JsonProperty("orderDetailList")
    private List<OrderDetailListDto> orderDetailList;

    /*public static OrderListDto build(OrderMaster orderMaster){
        OrderListDto orderListDto = new OrderListDto();
        BeanUtils.copyProperties(orderMaster,orderListDto);

        return orderListDto;
    }*/
}
