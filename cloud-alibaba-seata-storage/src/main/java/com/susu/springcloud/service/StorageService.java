package com.susu.springcloud.service;

import org.apache.ibatis.annotations.Param;

public interface StorageService {


    public void decrease(Long productId,Integer count);
}
