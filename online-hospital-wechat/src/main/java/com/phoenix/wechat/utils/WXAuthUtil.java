package com.phoenix.wechat.utils;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class WXAuthUtil {

    public static final String APPID = "wxfb8211ce0e0506c1";
    public static final String APPSECRET = "dd1e1c000fbca6eb962a37e20e1d9ddb";

    public static JSONObject doGetJson(String url) throws ClientProtocolException, IOException {
        JSONObject jsonObject = null;
        DefaultHttpClient client = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(url);
        HttpResponse response = client.execute(httpGet);
        HttpEntity entity = response.getEntity();
        if (entity != null) {
            // 把返回的结果转换为JSON对象
            String result = EntityUtils.toString(entity, "UTF-8");
            jsonObject = JSON.parseObject(result);
        }
        return jsonObject;
    }


    public static Boolean CheckSignature(String signature, String timestamp, String nonce) throws NoSuchAlgorithmException {
        //第一步中填写的token一致
        String token="centos";

        ArrayList<String> list=new ArrayList<String>();
        list.add(nonce);
        list.add(timestamp);
        list.add(token);

        //字典序排序
        Collections.sort(list);
        //SHA1加密
        String checksignature=Sha1Util.getSha1((list.get(0)+list.get(1)+list.get(2)).getBytes());
        System.out.println(signature);
        System.out.println(checksignature);

        if(checksignature.equals(signature)){
            return true;
        }
        return false;
    }

}