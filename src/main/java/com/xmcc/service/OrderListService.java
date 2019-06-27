package com.xmcc.service;

import com.xmcc.common.ResultResponse;
import com.xmcc.dto.OrderPageDto;

public interface OrderListService {
    ResultResponse queryOrderPageList(OrderPageDto orderPageDto);
}
