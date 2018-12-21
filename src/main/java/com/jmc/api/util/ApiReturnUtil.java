package com.jmc.api.util;

import com.alibaba.fastjson.JSONObject;
import com.jmc.api.common.Page;
import com.jmc.api.common.ReturnObj;
import org.springframework.boot.json.JacksonJsonParser;

import java.lang.reflect.Array;

/**
 * @Author: mason_ge
 * @Description: api返回数据处理工具
 * @Date: 9:57 2018/12/18
 */
public class ApiReturnUtil {

	public static ReturnObj handleData(Object obj) {
		ReturnObj ro = new ReturnObj();
		ro.setData(obj);
		ro.setCode(200);
		ro.setMes("success");
		return ro;
	}

	public static ReturnObj handleData(Object obj, Page pg) {
		ReturnObj ro = new ReturnObj();
		ro.setData(obj);
		ro.setCode(200);
		ro.setMes("success");
		ro.setPage(pg);
		return ro;
	}

	public static ReturnObj handleDataWithErro(String mes) {
		ReturnObj ro = new ReturnObj();
		ro.setData(null);
		ro.setCode(300);
		ro.setMes(mes);
		return ro;
	}

	private void convertData(Object obj){
		if(obj instanceof Array){

		}
	}
}
