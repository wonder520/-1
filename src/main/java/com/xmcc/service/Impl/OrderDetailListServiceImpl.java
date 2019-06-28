package com.xmcc.service.Impl;

import com.google.common.collect.Lists;
import com.xmcc.Utils.DateToStringUtils;
import com.xmcc.common.ResultResponse;
import com.xmcc.dto.OrderDetailListDto;
import com.xmcc.dto.OrderListDto;
import com.xmcc.entity.OrderDetail;
import com.xmcc.entity.OrderMaster;
import com.xmcc.repository.OrderDetailRepository;
import com.xmcc.repository.OrderMasterRepository;
import com.xmcc.service.OrderDetailListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailListServiceImpl implements OrderDetailListService {

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Override
    public ResultResponse<List<OrderListDto>> queryOrderDetail(String openid, String orderId) {


        OrderDetail orderDetail = orderDetailRepository.findByOrderId(orderId);

        if (orderDetail == null){
            System.out.println(orderDetail);
        }

        OrderMaster orderMaster  = orderMasterRepository.findByOrderIdAndBuyerOpenid(orderId, openid);


        OrderDetailListDto orderDetailListDto = OrderDetailListDto.builder().detailId(orderDetail.getDetailId())
                .orderId(orderDetail.getOrderId()).productId(orderDetail.getProductId()).productName(orderDetail.getProductName())
                .productPrice(orderDetail.getProductPrice()).productQuantity(orderDetail.getProductQuantity())
                .productIcon(orderDetail.getProductIcon()).productImage(orderDetail.getProductIcon()).build();

        List<OrderDetailListDto> orderDetailList = Lists.newArrayList();
        orderDetailList.add(orderDetailListDto);

        List<OrderListDto> orderListDtoList= Lists.newArrayList();



        OrderListDto orderListDto = OrderListDto.builder().orderId(orderMaster.getOrderId())
                .buyerName(orderMaster.getBuyerName()).buyerPhone(orderMaster.getBuyerPhone())
                .orderAmount(orderMaster.getOrderAmount()).orderStatus(orderMaster.getOrderStatus())
                .payStatus(orderMaster.getPayStatus()).createTime(DateToStringUtils.datetoString(orderMaster.getCreateTime()))
                .updateTime(DateToStringUtils.datetoString(orderMaster.getUpdateTime())).orderDetailList(orderDetailList).build();
        orderListDtoList.add(orderListDto);


        return ResultResponse.success(orderListDtoList);
    }


}
