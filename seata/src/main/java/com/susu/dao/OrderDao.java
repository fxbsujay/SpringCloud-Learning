package com.susu.dao;

import com.susu.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderDao {

   /**
    * 查询
    * @param id 订单Id
    */
   public Order info(@Param("id") Integer id);

   /**
    * 新增
    * @param order 订单
    */
   public void insert(Order order);

   /**
    * 修改
    * @param status 状态
    */
   public void update(@Param("name") String name,@Param("status") Integer status);

   /**
    * 删除
    * @param id 订单Id
    */
   public void remove(@Param("id") Integer id);
}
