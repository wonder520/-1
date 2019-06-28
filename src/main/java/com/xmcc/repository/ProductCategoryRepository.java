package com.xmcc.repository;

import com.xmcc.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer> {
    //根据类型列表查询结合
    List<ProductCategory> findByCategoryTypeIn(List<Integer> typeList);

    @Query(value = "select category_name from product_category where category_id=:ids and category_type=:type",nativeQuery = true)
    List<String> queryNameByIdAndType(@Param("ids") Integer id, Integer type);
}
