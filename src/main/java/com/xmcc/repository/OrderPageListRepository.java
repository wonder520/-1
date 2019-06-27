package com.xmcc.repository;

import com.xmcc.entity.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderPageListRepository extends JpaRepository<OrderMaster,Integer> {
    @Query(value = "select * from order_master where buyer_openid = :openid",nativeQuery = true)
    Page<OrderMaster> findAllByOpenid(@Param("openid") Integer openid, Pageable pageable);
    @Query(value = "select * from order_master where buyer_openid = :openid",nativeQuery = true)
    List<OrderMaster> findAllByOpenidIn(@Param("openid") Integer openid);
}
