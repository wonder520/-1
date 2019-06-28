package com.xmcc.service;

import com.xmcc.common.ResultResponse;
import com.xmcc.dto.OrderListDto;

import java.util.List;

public interface OrderDetailListService {

    ResultResponse<List<OrderListDto>> queryOrderDetail(String openid, String orderId);
}

