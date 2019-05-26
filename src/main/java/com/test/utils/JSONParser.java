package com.test.utils;

import com.alibaba.fastjson.JSONObject;

public class JSONParser {
	public String getCity(JSONObject o) {
		JSONObject interObject = o.getJSONObject("result");
		String city = interObject.getString("city");
		return city;
	}
}
