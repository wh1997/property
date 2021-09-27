package com.tianjian.property.management.service.impl;

import com.tianjian.property.utils.HttpClientUtil;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map.Entry;

import java.util.Map;

/**
 * @description:
 * @author: ManolinCoder
 * @time: 2021/9/17
 */
@Slf4j
public class CardHttpService {
    public Map postResult(String url, Map<String,String> map){
        log.info(url+"请求的参数为： "+map.toString());
       /* URL u = null;
        HttpURLConnection con = null;
        // 构建请求参数
        StringBuffer sb = new StringBuffer();
        for (Entry<String, String> e : map.entrySet()) {
            sb.append(e.getKey());
            sb.append("=");
            sb.append(e.getValue());
            sb.append("&");
        }
        sb.substring(0, sb.length() - 1);
        // 发送请求
        try {
            u = new URL(url);
            con = (HttpURLConnection) u.openConnection();

            con.setRequestMethod("POST");
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setUseCaches(false);
            con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            OutputStreamWriter osw = new OutputStreamWriter(con.getOutputStream(), "UTF-8");
            osw.write(sb.toString());
            osw.flush();
            osw.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                con.disconnect();
            }
        }

        // 读取返回内容
        StringBuffer buffer = new StringBuffer();
        try {
            // 一定要有返回值，否则无法把请求发送给server端。
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
            String temp;
            while ((temp = br.readLine()) != null) {
                buffer.append(temp);
                buffer.append("\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
*/
        Map resultMap = HttpClientUtil.doPost(url, map);
        log.info(url+"请求返回值为： "+resultMap.toString());
        return resultMap;
    }
}
