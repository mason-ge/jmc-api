package com.jmc.api.service;

import com.jmc.api.entity.SysEnumv;

import java.util.List;

/**
 * @Description:枚举接口
 * @Author: mason_ge
 * @Date: 14:32 2018/12/21
 */
public interface EnumService {

	/**
	 * 根据品类一级描述，获取品类二级列表
	 * 
	 * @param enumvDesc
	 * @return
	 */
	List<SysEnumv> findPlejByEnumvCode(String enumvDesc);

	/**
	 * 根据枚举项编码查询枚举值列表
	 * 
	 * @param enumCode
	 * @return
	 */
	List<SysEnumv> findEnumvByEnumCode(String enumCode);
}
