package com.tianjian.property;

import com.tianjian.property.management.service.CommonDoorService;
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

@SpringBootTest
@Controller
class PropertyLockApplicationTests {
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private NetworkCardServiceImpl networkCardService;
    @Autowired
    private PropertyService propertyService;
    @Test
    void redisceshi()  {
        Object o =  redisTemplate.opsForValue().get(LockConstants.USER_TOKEN + "eyJhbGciOiJBMTI4S1ciLCJlbmMiOiJBMTI4Q0JDLUhTMjU2In0.ans3h381RvqWidVJt4pu-bvbreBcpmuw2MeVWtzDBF7-pHo5KBiaDw.AS0TB4Yjlxj8K2raZuU1_g.aRd32S0UnMmMLrKiaczg-g.8eEj8eBv3RH7MgkZb8oFYA");
        System.out.println(o);
    }
    @Test
    void addRedis()  {
        Object o =  redisTemplate.opsForValue().get(LockConstants.USER_TOKEN + "eyJhbGciOiJBMTI4S1ciLCJlbmMiOiJBMTI4Q0JDLUhTMjU2In0.ans3h381RvqWidVJt4pu-bvbreBcpmuw2MeVWtzDBF7-pHo5KBiaDw.AS0TB4Yjlxj8K2raZuU1_g.aRd32S0UnMmMLrKiaczg-g.8eEj8eBv3RH7MgkZb8oFYA");
        System.out.println(o);
    }
    @Test
    void test()  {
        List map = networkCardService.selectEquipment(103);
        System.out.println(map);
    }
    @Test
    void test1()  {
        Map map = networkCardService.openLock("867157046608501","100069.0","103");
        System.out.println(map);
    }
    @Test
    void test2()  {
        Map map = networkCardService.selectEquipmentStatus("867157046608501");
        System.out.println(map);
    }
    @Test
    void test3()  {
        List map = propertyService.getBuildings(100042 );
        System.out.println(map);
    }
    @Test
    void test4()  {
        List map = propertyService.getApartments(10000070 );
        System.out.println(map);
    }
    @Test
    void test5()  {
        List map = propertyService.getProperty();
        System.out.println(map);
    }
}