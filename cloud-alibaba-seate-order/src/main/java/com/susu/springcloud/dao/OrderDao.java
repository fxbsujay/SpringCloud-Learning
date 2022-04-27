package com.susu.springcloud.dao;

import com.susu.springcloud.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author sujay
 * @Description 描述
 * @Date 15:57 2022/4/27
 */
@Mapper
public interface OrderDao {

   /**
    * 新增
    * @param order 订单
    */
   public void insert(Order order);

   /**
    * 修改
    * @param userId 用户id
    * @param status 状态
    */
   public void update(@Param("userId") Long userId,@Param("status") Integer status);
}
