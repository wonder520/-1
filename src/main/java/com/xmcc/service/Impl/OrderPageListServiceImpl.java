package com.xmcc.service.Impl;

import com.google.common.collect.Lists;
import com.xmcc.Utils.DateToStringUtils;
import com.xmcc.common.OrderEnums;
import com.xmcc.common.ResultResponse;
import com.xmcc.dto.OrderListDto;
import com.xmcc.dto.OrderPageDto;
import com.xmcc.entity.OrderMaster;
import com.xmcc.repository.OrderPageListRepository;
import com.xmcc.service.OrderListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderPageListServiceImpl implements OrderListService {

    @Autowired
    private OrderPageListRepository orderPageListRepository;


    @Override
    public ResultResponse queryOrderPageList(OrderPageDto orderPageDto) {

        Pageable pageable = PageRequest.of(orderPageDto.getPage(),orderPageDto.getSize());

        Page<OrderMaster> allByOpenid = orderPageListRepository.findAllByOpenid(orderPageDto.getOpenid(), pageable);

        if (allByOpenid == null){
            return ResultResponse.fail(OrderEnums.OPENID_ERROR.getMsg());
        }


        List<OrderListDto> orderListDtoList= Lists.newArrayList();
        List<OrderMaster> list = allByOpenid.getContent();
        for (OrderMaster orderMaster:list) {
            OrderListDto orderListDto = OrderListDto.builder().orderId(orderMaster.getOrderId())
                    .buyerName(orderMaster.getBuyerName()).buyerPhone(orderMaster.getBuyerPhone())
                    .orderAmount(orderMaster.getOrderAmount()).orderStatus(orderMaster.getOrderStatus())
                    .payStatus(orderMaster.getPayStatus()).createTime(DateToStringUtils.datetoString(orderMaster.getCreateTime()))
                    .updateTime(DateToStringUtils.datetoString(orderMaster.getUpdateTime())).build();
            orderListDtoList.add(orderListDto);
        }

        Page<OrderListDto> page = new PageImpl(orderListDtoList,pageable,orderListDtoList.size());

        //转换Dto
//        OrderListDto orderListDto = new OrderListDto();
//        List<OrderMaster> list = orderPageListRepository.findAllByOpenidIn(orderPageDto.getOpenid());
//        List<OrderListDto> collect = list.stream().map(orderMaster -> orderListDto.build(orderMaster)).collect(Collectors.toList());
//
//        Page page = new PageImpl(collect,pageable,collect.size());


        return ResultResponse.success(page);
    }
}
