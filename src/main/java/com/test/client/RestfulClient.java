package com.test.client;

import java.util.HashMap;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;

import com.alibaba.fastjson.JSONObject;

public class RestfulClient {
  CloseableHttpClient httpClient;
  HttpGet httpGet;
  CloseableHttpResponse httpResponse;
  int responseCode;
  JSONObject responseBody;
  HashMap<String, String> responseHeads;
  
  
}
