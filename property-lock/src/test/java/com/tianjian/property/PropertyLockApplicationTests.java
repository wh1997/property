package com.tianjian.property;

import com.tianjian.property.bean.Door;
import com.tianjian.property.bean.Property;
import com.tianjian.property.bean.Role;
import com.tianjian.property.bean.vo.DoorVo;
import com.tianjian.property.management.service.*;
import com.tianjian.property.utils.PageResult;
import com.tianjian.property.web.service.UserLoginService;
import com.tianjian.property.web.service.ManageService;
import com.tianjian.property.web.service.MonitorService;
import com.tianjian.property.web.service.PermissionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.HashMap;
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
    private com.tianjian.property.management.service.UserService userService;
    @Autowired
    private ManageService manageService;
    @Autowired
    private UserLoginService loginService;
    @Autowired
    private PermissionService permissionService;
    @Autowired
    private MonitorService monitorService;
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
    @Test
    void test8()  {
        Object o = manageService.BluetoothdDetails("0tyxLhB8vJ8=");
        System.out.println(o);
    }
    //网关详情测试
    @Test
    void test3()  {
        gatewayService.selectGateway("Zkg8OGRQ4Yk=");
    }
    //登录测试
    @Test
    void test9() throws Exception {
        //LockResult login = loginService.login("15873306605");
       // System.out.println(login.getErrorMessage());
    }
    @Test
    void test10() throws Exception {
        Role role = new Role();
        role.setName("鲁班");
        PageResult<Role> result = permissionService.selectRole(role, 1, 1);
        System.out.println(result.getRows().get(0).getName());
    }
    @Test
    void test11() throws Exception {
        ArrayList<Integer> integers1 = new ArrayList<>();
        integers1.add(0);
        integers1.add(1);
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(100008);
        PageResult<DoorVo> doorVoPageResult = monitorService.selectPublicDoor(new Door(),integers1, integers, 1, 5);
        System.out.println(doorVoPageResult.getRows());
    }
    @Test
    void test7()  {
        HashMap<String, Object> map1 = new HashMap<>();
        map1.put("adminAuthCode","9dd263fc");
        HashMap<String, Object> map2 = new HashMap<>();
        map2.put("generalAuthCode","aac4cceb");
        HashMap<String, Object> map3 = new HashMap<>();
        map3.put("tempAuthCode","378c3ea9");
        ArrayList<Map> list = new ArrayList<>();
        list.add(map1);
        list.add(map2);
        list.add(map3);
        HashMap<String, Object> lockAuthCode = new HashMap<>();
        lockAuthCode.put("aesKey","hWTCnp9YfX7vK2Md");
        lockAuthCode.put("authCodeList",list);
        String aesKey = (String) lockAuthCode.get("aesKey");
        List<Map> authCodeList = (List<Map>) lockAuthCode.get("authCodeList");
        String adminAuthCode=null;
        String generalAuthCode=null;
        String tempAuthCode=null;
        List<Map> maps = new ArrayList<>();
                        System.out.println(authCodeList.size());
                for (int i = 0; i <authCodeList.size() ; i++) {
                    Map map = authCodeList.get(i);
                    if (map.get("adminAuthCode")!=null){
                        HashMap<String, Object> hashMap = new HashMap<>();
                        adminAuthCode = (String) map.get("adminAuthCode");
                        System.out.println(adminAuthCode);
                        hashMap.put("authCode",adminAuthCode);
                hashMap.put("authCodeType",1);
                maps.add(hashMap);
            }
            if (map.get("generalAuthCode")!=null){
                HashMap<String, Object> hashMap = new HashMap<>();
                generalAuthCode = (String) map.get("generalAuthCode");
                System.out.println(generalAuthCode);
                hashMap.put("authCode",generalAuthCode);
                hashMap.put("authCodeType",2);
                maps.add(hashMap);
            }
            if (map.get("tempAuthCode")!=null){
                HashMap<String, Object> hashMap = new HashMap<>();
                tempAuthCode = (String) map.get("tempAuthCode");
                System.out.println(tempAuthCode);
                hashMap.put("authCode",tempAuthCode);
                hashMap.put("authCodeType",3);
                maps.add(hashMap);
            }
        }
        System.out.println(maps);
        System.out.println(adminAuthCode+"  "+generalAuthCode+"  "+tempAuthCode);
    }

}