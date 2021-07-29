package com.tianjian.property.management.service.impl;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import com.tianjian.property.bean.Role;
import com.tianjian.property.management.dao.RoleDao;
import com.tianjian.property.management.service.PhoneLoginService;
import com.tianjian.property.utils.HttpClientUtil;
import com.tianjian.property.utils.HttpUtils;
import com.tianjian.property.utils.LockConstants;
import com.tianjian.property.utils.TokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;


@Service
public class PhoneLoginServiceImpl implements PhoneLoginService {
    private static final Logger logger = LoggerFactory.getLogger(PhoneLoginServiceImpl.class);
    @Value("${baiwei.WXurl}")
    private String WXurl;
    @Value("${lock.appid}")
    private String appid;
    @Value("${baiwei.url}")
    private String url;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private RoleDao roleDao;
    //进行微信授权登陆
    @Override
    public HashMap<String, Object> wechatLogin(String encryptedData, String iv, String code) throws Exception {
        //存储返回结果
        HashMap<String, Object> resultMap = new HashMap<>();
        Map<String, String> phoneMap = getPhone(encryptedData, iv, code);
        String phone = phoneMap.get("phone");
        String token = phoneMap.get("token");
        HashMap<String, String> map = new HashMap<>();
        //map.put("Namespace","");
        map.put("Identity",phone);
        map.put("Token",token);
        Gson gson = new Gson();
        String json = gson.toJson(map);
        Integer Propertyid=0;
        //判断用户是否存在 如果是204则表示用户已存在若果是404则表示用户不存在需要注册
        Integer status = HttpUtils.doGetExists(url + "/Security/Users/Exists/*:"+phone);
        if (404==status){
            //进行注册的接口
            String registerResult= HttpClientUtil.doPostJson(url + "/Security/Users/Register?token=wechat:"+token, json);
            Gson registergson = new Gson();
            Map fromJson = registergson.fromJson(registerResult, Map.class);
            Double userId = (Double) fromJson.get("UserId");
            if(null!=userId){
            //往角色表里添加角色
                Role role = new Role();
                role.setUserid(userId);
                role.setRole(2);
                role.setPropertyid(Propertyid);
                //往角色表里面添加数据
                int i = roleDao.insert(role);
                if (1!=i){
                    resultMap.put("code",403);
                    resultMap.put("errorMessage","注册失败");
                    return resultMap;
                }
            }
        }
        //登录接口
        String loginResult = HttpClientUtil.doPostJson(url + "/Security/Authentication/Signin/wechat?scenario=Mobile",json);
        HashMap<String,Object> hashMap = gson.fromJson(loginResult, HashMap.class);
        LinkedTreeMap<String,Object> identity = (LinkedTreeMap<String, Object>) hashMap.get("Identity");
        if(null ==identity){
            resultMap.put("code",400);
            resultMap.put("errorMessage","登录失败");
            return resultMap;
        }
        Double userId = (Double) identity.get("UserId");
        Map roletype= null;
        //判断角色表有没有添加没有添加进行添加
        roletype=roleDao.selectByUserId(userId);
        if (roletype.isEmpty()){
            Role newrole = new Role();
            newrole.setUserid(userId);
            newrole.setRole(2);
            newrole.setPropertyid(0);
            //往角色表里面添加数据
            int i = roleDao.insert(newrole);
            //如果没有添加角色后返回
           roletype.put("role",2);
           roletype.put("Property_id",0);
        }
        String userToken = TokenUtil.createToken(userId);
        redisTemplate.opsForValue().set(LockConstants.USER_TOKEN+userToken,hashMap,1, TimeUnit.DAYS);
        logger.info("用户的token为"+userToken);
        HashMap<String, Object> datemap = new HashMap<>();
        datemap.put("role",roletype.get("role"));
        datemap.put("Property_id",roletype.get("property_id"));
        datemap.put("token",userToken);
        datemap.put("datemap",hashMap);
        resultMap.put("code",200);
        resultMap.put("errorMessage","登录成功");
        resultMap.put("date",datemap);
        return resultMap;
    }

    @Override
    public boolean wechatLogOut(String token) {
        return redisTemplate.delete(LockConstants.USER_TOKEN + token);
    }

    //获取手机号以及注册登陆要用到的token参数(百为)
    public Map<String,String> getPhone(String encryptedData,String iv,String code)   {
        String encryptedDataA = encryptedData.replaceAll(" ", "+");
        //获取sessionKey参数
        String s = HttpClientUtil.doGet(WXurl + "/wx/auth/" + appid + "/code2Session/" + code);
        Gson gson = new Gson();
        Map parse = gson.fromJson(s, Map.class);
        String sessionKey = (String) parse.get("sessionKey");
        String encodeEncryptedData = encodeURL(encryptedDataA);
        String encodeSessionKey = encodeURL(sessionKey);
        String encodeIv = encodeURL(iv);
        String url=WXurl + "/wx/auth/" + appid + "/phone?sessionKey="+encodeSessionKey+"&encryptedData="+encodeEncryptedData+"&iv="+encodeIv;
        String myphone = HttpClientUtil.doGet(url);
        Map jsonMap = gson.fromJson(myphone, Map.class);
        //获取手机号
        String phone = (String) jsonMap.get("purePhoneNumber");
        //获取token值
        String token =(String) jsonMap.get("token");
        HashMap<String, String> resultMap = new HashMap<>();
        resultMap.put("phone",phone);
        resultMap.put("token",token);
        logger.info("登录手机号:"+phone+"  它的(百为)token为"+token);
        return resultMap;
    }
    public static String encodeURL(String url){
        return url.replace("%", "%25").replace("+", "%2B")
                .replace(" ", "%20").replace("/", "%2F")
                .replace("?", "%3F").replace("#", "%23")
                .replace("&", "%26").replace("=", "%3D")
                .replace(":", "%3A");
    }

}
