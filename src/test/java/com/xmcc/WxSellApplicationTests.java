package com.xmcc;

import com.google.common.collect.Lists;
import com.xmcc.Utils.DateToStringUtils;
import com.xmcc.dto.OrderDetailListDto;
import com.xmcc.dto.OrderListDto;
import com.xmcc.entity.OrderDetail;
import com.xmcc.entity.OrderMaster;
import com.xmcc.repository.OrderDetailRepository;
import com.xmcc.repository.OrderMasterRepository;
import com.xmcc.repository.OrderPageListRepository;
import com.xmcc.repository.ProductCategoryRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WxSellApplicationTests {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;
    @Autowired
    private OrderPageListRepository orderPageListRepository;
    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Test
    public void contextLoads() {
//        Optional<ProductCategory> one = productCategoryRepository.findById(1);
//        List<ProductCategory> all = productCategoryRepository.findAll();
        List<String> strings = productCategoryRepository.queryNameByIdAndType(2,2);
        strings.stream().forEach(System.out::println);
    }

    @Test
    public void findByTypeIn(){

//        Pageable pageable = PageRequest.of(1,10);
//        Page<OrderMaster> all= orderPageListRepository.findAllByOpenid(243520394, pageable);
//
//        List<OrderMaster> list = all.getContent();
//        OrderListDto orderListDto = new OrderListDto();
//        List<OrderListDto> collect = list.stream().map(orderMaster -> orderListDto.build(orderMaster)).collect(Collectors.toList());
//        Page<OrderListDto> page = new PageImpl(collect);
//
//        List<OrderListDto> content = page.getContent();
//
//        System.out.println(content);

        OrderDetail orderDetail = orderDetailRepository.findByOrderId("0bd39361cc914a78a39562c9f3765cc0");

        OrderMaster orderMaster  = orderMasterRepository.findByOrderIdAndBuyerOpenid("0bd39361cc914a78a39562c9f3765cc0", "243520394");

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

        System.out.println(":::::::::"+orderDetailList);
        System.out.println("::::::::::"+orderListDtoList);

    }

}
