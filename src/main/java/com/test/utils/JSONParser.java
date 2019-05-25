package com.test.utils;

import com.alibaba.fastjson.JSONObject;

public class JSONParser {
	public String getCity(JSONObject o) {
		JSONObject interObject = o.getJSONObject("__GetZoneResult_");
		String city = interObject.getString("province");
		return city;
	}
}
