package com.jmc.api.service;

import com.jmc.api.common.Page;

import java.util.List;
import java.util.Map;

/**
 * @Description: 商品接口
 * @Author: mason_ge
 * @Date: 10:17 2018/12/18
 */
public interface ProdService {

	/**
	 * 分页获取商品列表
	 *
	 * @param param
	 * @param pg
	 * @return
	 */
	List<Map<String, Object>> getProdList(Map<String, Object> param, Page pg);
}
