package com.xmcc.controller;


import com.xmcc.common.ResultResponse;
import com.xmcc.dto.OrderListDto;
import com.xmcc.dto.OrderPageDto;
import com.xmcc.service.OrderDetailListService;
import com.xmcc.service.OrderListService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("buyer/order")
@Api(value = "订单相关接口",description = "分页查询订单列表")
public class OrderPageListController {

    @Autowired
    private OrderListService orderListService;
    @Autowired
    private OrderDetailListService orderDetailListService;

    @GetMapping("list")
    @ApiOperation(value = "订单列表")
    public ResultResponse list(String openid,Integer page,Integer size){

        page = page-1;
        OrderPageDto orderPageDto = OrderPageDto.builder().openid(openid).page(page).size(size).build();

        return orderListService.queryOrderPageList(orderPageDto);
    }

    @GetMapping("detail")
    @ApiOperation(value = "查询订单详情")
    public ResultResponse detail(String openid,String orderId){

        ResultResponse<List<OrderListDto>> response = orderDetailListService.queryOrderDetail(openid, orderId);

        return response;
    }


}
