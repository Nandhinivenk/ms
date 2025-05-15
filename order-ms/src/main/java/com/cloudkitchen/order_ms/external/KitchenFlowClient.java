package com.cloudkitchen.order_ms.external;
// order-ms/src/main/java/com/cloudkitchen/order_ms/external/KitchenFlowClient.java

import com.cloudkitchen.order_ms.dto.KitchenFlowRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "kitchenflow-ms", url = "http://localhost:8097/kitchen") // match with service name in Eureka
public interface KitchenFlowClient {
    @PostMapping
    void createKitchenFlow(@RequestBody KitchenFlowRequest request);
}
