package com.xmcc.dto;


import com.xmcc.entity.OrderDetail;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@ApiModel("订单列表实体类")
public class OrderListDto {


    @NotBlank(message = "订单号不能为空")
    @ApiModelProperty(value = "订单号",dataType = "String")
    private String orderId;

    @NotBlank(message = "购买者不能为空")
    @ApiModelProperty(value = "购买者",dataType = "String")
    private String buyerName;

    @NotBlank(message = "购买者电话不能为空")
    @ApiModelProperty(value = "购买者电话",dataType = "String")
    private String buyerPhone;

    @NotBlank(message = "购买者地址不能为空")
    @ApiModelProperty(value = "购买者地址",dataType = "String")
    private String buyerAddress;

    @NotBlank(message = "购买者微信号不能为空")
    @ApiModelProperty(value = "购买者微信号",dataType = "String")
    private String buyerOpenid;

    @NotBlank(message = "商品总价格不能为空")
    @ApiModelProperty(value = "商品总价格",dataType = "String")
    private BigDecimal orderAmount;

    @NotBlank(message = "订单状态不能为空")
    @ApiModelProperty(value = "订单状态",dataType = "String")
    private Integer orderStatus;

    @NotBlank(message = "付费状态不能为空")
    @ApiModelProperty(value = "付费状态",dataType = "String")
    private Integer payStatus;

    @NotNull(message = "生成订单时间不能为空")
    @ApiModelProperty(value = "生成订单时间",dataType = "Date")
    private String createTime;

    @NotNull(message = "更新订单时间不能为空")
    @ApiModelProperty(value = "更新订单时间",dataType = "Date")
    private String updateTime;

    @Valid //表示需要嵌套验证
    @ApiModelProperty(value = "订单项集合",dataType = "List")
    private List<OrderDetail> orderDetailList = null;

    /*public static OrderListDto build(OrderMaster orderMaster){
        OrderListDto orderListDto = new OrderListDto();
        BeanUtils.copyProperties(orderMaster,orderListDto);

        return orderListDto;
    }*/
}
