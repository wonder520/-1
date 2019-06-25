package com.xmcc.service.Impl;

import com.xmcc.common.ResultEnums;
import com.xmcc.common.ResultResponse;
import com.xmcc.dto.ProductCategoryDto;
import com.xmcc.dto.ProductInfoDto;
import com.xmcc.entity.ProductInfo;
import com.xmcc.repository.ProductInfoRespository;
import com.xmcc.service.ProductCategoryService;
import com.xmcc.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductInfoServiceImpl implements ProductInfoService {

    @Autowired
    private ProductInfoRespository productInfoRespository;

    @Autowired
    private ProductCategoryService productCategoryService;

    @Override
    public ResultResponse queryList() {
        ResultResponse<List<ProductCategoryDto>> categoryServiceResult = productCategoryService.findAll();
        List<ProductCategoryDto> categoryDtoList = categoryServiceResult.getData();

        if (CollectionUtils.isEmpty(categoryDtoList)){
            //分类列表为空 直接返回
            return categoryServiceResult;
        }

        //获得类目编号集合
        List<Integer> collectTypeList = categoryDtoList.stream().map(categoryDto -> categoryDto.getCategoryType()).collect(Collectors.toList());

        //查询商品列表 这里商品上下架可以用枚举
        List<ProductInfo> productInfoList = productInfoRespository.findByProductStatusAndCategoryTypeIn(ResultEnums.PRODUCT_UP.getCode(), collectTypeList);

        //多线程遍历 取出没个商品类目编号对应的 商品列表 设置进入类目中
        List<ProductCategoryDto> finalResultList = categoryDtoList.parallelStream().map(categoryDto -> {
            categoryDto.setProductInfoDtoList(productInfoList.stream()
                    //判断两张表中的类型是否一致
                    .filter(productInfo -> productInfo.getCategoryType() == categoryDto.getCategoryType())
                    //如果类型,进行封装
                    .map(productInfo -> ProductInfoDto.build(productInfo)).collect(Collectors.toList()));
            return categoryDto;
        }).collect(Collectors.toList());
        return ResultResponse.success(finalResultList);

    }
}
