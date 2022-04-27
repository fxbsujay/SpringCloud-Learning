package com.susu.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author sujay
 * @Description 描述
 * @Date 15:57 2022/4/27
 */
@Mapper
public interface StorageDao {

   public void decrease(@Param("productId") Long productId,@Param("count") Integer count);
}
