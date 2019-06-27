package com.xmcc;

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

    }

}
