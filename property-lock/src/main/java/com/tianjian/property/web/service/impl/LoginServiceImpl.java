package com.tianjian.property.web.service.impl;

import com.tianjian.property.bean.User;
import com.tianjian.property.dao.UserDao;
import com.tianjian.property.management.service.impl.HttpService;
import com.tianjian.property.utils.LockConstants;
import com.tianjian.property.utils.LockResult;
import com.tianjian.property.utils.TokenUtil;
import com.tianjian.property.utils.error.ErrorEnum;
import com.tianjian.property.web.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: ManolinCoder
 * @time: 2021/11/12
 */
@Service
public class LoginServiceImpl  extends HttpService implements LoginService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private RedisTemplate redisTemplate;
    @Override
    public LockResult login(String phone) throws Exception {
        HashMap<String, Object> map = new HashMap<>();
        map.put("Identity",phone);
        map.put("Password","654321asd");
        Map fromJson = (Map) postResult("http://client.api.melifego.cn/Security/Authentication/Signin?scenario=Mobile", map);
        Map<String,Object> identity = (Map<String, Object>) fromJson.get("Identity");
        if (identity==null){
            return new LockResult(false,"登录失败", ErrorEnum.OPERATION_ERROR.getCode(),"");
        }
        Integer userId = (Integer) identity.get("UserId");
        String name = (String) identity.get("FullName");
        User user = new User();
        user.setPhone(phone);
        user.setName(name);
        user.setUserId(userId);
        List<User> select = userDao.select(user);
        if (select!=null){
            String userToken = TokenUtil.createToken(userId);
            redisTemplate.opsForValue().set(LockConstants.WEB_USER_TOKEN+userToken,fromJson,1, TimeUnit.DAYS);
            fromJson.put("token",userToken);
            return new LockResult(true,"登录成功", ErrorEnum.SUCCESS.getCode(),fromJson);
        }else {
            return new LockResult(true,"登录失败,请先注册", ErrorEnum.OPERATION_ERROR.getCode(),"");
        }
    }
}
