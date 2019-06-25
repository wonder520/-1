package com.xmcc;

import com.google.common.collect.Lists;
import com.xmcc.entity.ProductCategory;
import com.xmcc.repository.ProductCategoryRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WxSellApplicationTests {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;


    @Test
    public void contextLoads() {
//        Optional<ProductCategory> one = productCategoryRepository.findById(1);
//        List<ProductCategory> all = productCategoryRepository.findAll();
        List<String> strings = productCategoryRepository.queryNameByIdAndType(2,2);
        strings.stream().forEach(System.out::println);
    }

    @Test
    public void findByTypeIn(){
        List<ProductCategory> categories= productCategoryRepository.findByCategoryTypeIn(Lists.newArrayList(1,2,3));
        categories.stream().forEach(System.out::println);
    }

}
