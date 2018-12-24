package com.jmc.api.service;

import com.jmc.api.entity.Bdf2User;

import java.util.Map;

/**
 * @description:用户接口
 * @Author: mason_ge
 * @Date: 16:25 2018/12/21
 */
public interface UserService {
	/**
	 * 根据Bdf2User属性查询用户
	 * 
	 * @param map
	 * @return
	 */
	Bdf2User getUserByMap(Map<String, Object> map);

	/**
	 * 保存用户
	 * 
	 * @param user
	 * @return
	 */
	void saveUser(Bdf2User user);
}
