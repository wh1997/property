package com.tianjian.property;

import com.tianjian.property.management.service.CommonDoorService;
import com.tianjian.property.management.service.GatewayService;
import com.tianjian.property.management.service.NetworkCardService;
import com.tianjian.property.management.service.PropertyService;
import com.tianjian.property.management.service.impl.NetworkCardServiceImpl;
import com.tianjian.property.utils.LockConstants;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;

import static org.bouncycastle.asn1.x500.style.RFC4519Style.o;

@SpringBootTest
@Controller
class PropertyLockApplicationTests {
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private NetworkCardService networkCardService;
    @Autowired
    private GatewayService gatewayService;
    @Test
    void redisceshi()  {
       redisTemplate.opsForValue().set("嘻嘻呵呵","hahahaha");
    }
    @Test
    void test()  {
        Map map = networkCardService.openLock("864626047482697", "123", "103");
        System.out.println(map);
    }
    @Test
    void test1()  {
        List list = networkCardService.selectEquipment(103);
        System.out.println(list);
    }
    @Test
    void test2()  {
        String apartment = gatewayService.getApartment();
        System.out.println(apartment);
    }

}