package com.tianjian.property.management.service.impl;

import com.alibaba.fastjson.JSON;
import com.tianjian.property.utils.HttpClientUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * @description:
 * @author: ManolinCoder
 * @time: 2021/9/17
 */
@Slf4j
public class CardHttpService {
    public Object postResult(String url, Map map){
        log.info("请求的地址为： "+url);
        log.info("请求的参数为： "+map.toString());
        Map result = HttpClientUtil.doPost(url, map);
        log.info(url+"请求返回值为："+result.toString());
        return result.get("result");
    }
}
