package com.test.api;

import java.io.IOException;

import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.alibaba.fastjson.JSONObject;
import com.test.client.RestfulClient;
import com.test.utils.JSONParser;

public class testGet {

	JSONObject responseBody;
	int responseCode;
	String city;
	String url = "https://tcc.taobao.com/cc/json/mobile_tel_segment.htm?tel=15001958582";

	@Test
	public void testGetRequest() throws ClientProtocolException, IOException {
		RestfulClient restfulClient = new RestfulClient();
		restfulClient.getResponse(url);
	//	responseBody = restfulClient.getBodyInJSON();
		responseBody = restfulClient.getBodyInJSON();
		responseCode = restfulClient.getResponseCode();
		JSONParser jParser = new JSONParser();
		city = jParser.getCity(responseBody);
		Assert.assertEquals(city, "上海");
		Assert.assertEquals(responseCode, 200);
	}

	public void beforeTest() throws ParseException, IOException {

	}

}
