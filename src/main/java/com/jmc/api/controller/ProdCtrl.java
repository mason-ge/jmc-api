package com.jmc.api.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jmc.api.common.Page;
import com.jmc.api.common.ReturnObj;
import com.jmc.api.service.ProdService;
import com.jmc.api.util.ApiReturnUtil;
import com.jmc.api.util.BaseUtil;

/**
 * @Description: 商品接口控制层
 * @Author: mason_ge
 * @Date: 16:50 2018/12/13
 */
@RestController
@RequestMapping(value = "/prod")
public class ProdCtrl {

	// 构造器方式注入依赖
	private final ProdService prodService;

	@Autowired
	public ProdCtrl(ProdService prodService) {
		this.prodService = prodService;
	}

	/**
	 * 分页获取商品列表
	 * 
	 * @param reqBody
	 * @return
	 */
	@RequestMapping(value = "/getProdList", method = RequestMethod.POST)
	public ReturnObj getProdList(@RequestBody Map<String, Object> reqBody) {
		Page pg = new Page();
		int pageSize, pageNo;
		List<Map<String, Object>> list;
		try {
			if (reqBody.get("pageSize") != null) {
				pg.setPageSize(BaseUtil.obj2int(reqBody.get("pageSize")));
			}
			if (reqBody.get("pageNo") != null) {
				pg.setPageNo(BaseUtil.obj2int(reqBody.get("pageNo")));
			}
			if (StringUtils.isEmpty(reqBody.get("client"))) {
				return ApiReturnUtil.handleDataWithErro("请传入客户端号");
			} else {
				list = prodService.getProdList(reqBody, pg);
				return ApiReturnUtil.handleData(list, pg);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ApiReturnUtil.handleDataWithErro(e.getMessage());
		}

	}
}
