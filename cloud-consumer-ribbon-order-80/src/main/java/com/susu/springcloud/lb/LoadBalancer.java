package com.susu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author sujay
 */
public interface LoadBalancer {

    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
