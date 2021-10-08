package com.tianjian.property;

import com.tianjian.property.bean.Property;
import com.tianjian.property.management.service.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SpringBootTest
@Controller
class PropertyLockApplicationTests {
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private NetworkCardService networkCardService;
    @Autowired
    private GatewayService gatewayService;
    @Autowired
    private UserService userService;
    @Test
    void redisceshi()  {
       redisTemplate.opsForValue().set("嘻嘻呵呵","hahahaha");
    }
    @Test
    void test()  {
        Map map = networkCardService.openLock("867157046608501", "123", "100001");
        String status = (String) map.get("status");
        System.out.println(status);
    }
    @Test
    void test4()  {
        Map map = networkCardService.selectEquipmentStatus("867157046608501");
        System.out.println(map.toString());
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
    @Test
    void test5()  {
        userService.selectUserByRole(100069);
    }
    @Test
    void test6()  {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        List<Property> properties = userService.selectPropertyByRole(integers);
        System.out.println(properties);
    }
    //网关详情测试
    @Test
    void test3()  {
        Integer integer = gatewayService.selectGateway("Zkg8OGRQ4Yk=");
    }

}