package com.xmcc.repository;

import com.xmcc.entity.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderMasterRepository extends JpaRepository<OrderMaster,String> {

    OrderMaster findByOrderIdAndBuyerOpenid(String orderId,String openid);
}
