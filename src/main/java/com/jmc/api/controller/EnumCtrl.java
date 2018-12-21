package com.jmc.api.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import com.jmc.api.common.ReturnObj;
import com.jmc.api.entity.SysEnumv;
import com.jmc.api.service.EnumService;
import com.jmc.api.util.ApiReturnUtil;
import com.jmc.api.util.BaseUtil;

/**
 * @Description:枚举控制层
 * @Author: mason_ge
 * @Date: 14:13 2018/12/21
 */
@RestController
@RequestMapping(value = "/enum")
public class EnumCtrl {

	// 构造器方式注入依赖
	private final EnumService enumService;

	@Autowired
	public EnumCtrl(EnumService enumService) {
		this.enumService = enumService;
	}

	/**
	 * 根据品类一级编码获取品类二级列表
	 *
	 * @param reqBody
	 * @return
	 */
	@RequestMapping(value = "/getSecCatgByFirstDesc", method = RequestMethod.POST)
	public ReturnObj getSecCatgByFirstDesc(@RequestBody Map<String, Object> reqBody) {
		List<SysEnumv> list;
		try {
			String enumvDesc = BaseUtil.object2String(reqBody.get("firstDesc"));
			if (StringUtils.isEmpty(enumvDesc)) {
				return ApiReturnUtil.handleDataWithErro("未传入品类一级描述");
			}
			// 根据品类一级描述，获取品类二级列表
			list = enumService.findPlejByEnumvCode(enumvDesc);
		} catch (Exception e) {
			e.printStackTrace();
			return ApiReturnUtil.handleDataWithErro(e.getMessage());
		}
		return ApiReturnUtil.handleData(list);
	}

	/**
	 * 根据枚举值Code获取枚举值列表
	 * 
	 * @param enumCode
	 * @return
	 */
	@RequestMapping(value = "/getEnumListByCode/{enumCode}", method = RequestMethod.GET)
	public ReturnObj getEnumListByCode(@PathVariable String enumCode) {
		List<SysEnumv> list;
		try {
			// 获取枚举值列表
			list = enumService.findEnumvByEnumCode(enumCode);
		} catch (Exception e) {
			e.printStackTrace();
			return ApiReturnUtil.handleDataWithErro(e.getMessage());
		}
		return ApiReturnUtil.handleData(list);
	}

}
