package com.susu.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * @Author sujay
 * @Description 描述
 * @Date 15:57 2022/4/27
 */
@Mapper
public interface AccountDao {

   public void decrease(@Param("userId") Long userId,@Param("money") BigDecimal money);
}
