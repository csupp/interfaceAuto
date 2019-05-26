package com.test.client;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sun.xml.internal.messaging.saaj.packaging.mime.Header;

public class RestfulClient {
	CloseableHttpClient httpClient;
	HttpGet httpGet;
	CloseableHttpResponse httpResponse;
	int responseCode;
	JSONObject responseBody;
	HashMap<String, String> responseHeads;

	/**
	 * 通过httpclient获取请求反馈
	 * 
	 * @param url
	 * @throws IOException
	 * @throws ClientProtocolException
	 */
	public void getResponse(String url) throws ClientProtocolException, IOException {
		httpClient = HttpClients.createDefault();
		httpGet = new HttpGet(url);
		httpResponse = httpClient.execute(httpGet);
	}

	/**
	 * 以JSON的格式获取反馈的主体
	 * 
	 * @return
	 * @throws ParseException
	 * @throws IOException
	 */
	public JSONObject getBodyInJSON() throws ParseException, IOException {
		HttpEntity entity;
		String entityToString;
		entity = httpResponse.getEntity();
		entityToString = EntityUtils.toString(entity);
		responseBody = JSON.parseObject(entityToString);
		return responseBody;

	}

	/**
	 * Get response heads by hashmap
	 * 
	 * @return
	 */
	public HashMap<String, String> getHeaderInHash() {
		Header[] headers = (Header[]) httpResponse.getAllHeaders();
		responseHeads = new HashMap<String, String>();
		for (Header header : headers) {
			responseHeads.put(header.getName(), header.getValue());

		}
		return responseHeads;

	}

	public int getResponseCode() {
		responseCode = httpResponse.getStatusLine().getStatusCode();
		return responseCode;
	}

}
