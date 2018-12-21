package com.jmc.api.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jmc.api.common.ReturnObj;
import com.jmc.api.entity.Bdf2User;
import com.jmc.api.service.UserService;
import com.jmc.api.util.ApiReturnUtil;
import com.jmc.api.util.BaseUtil;

/**
 * @Description:用户控制层
 * @Author: mason_ge
 * @Date: 15:56 2018/12/21
 */
@RestController
@RequestMapping(value = "/user")
public class UserCtrl {

	// 构造器方式注入依赖
	private final UserService userService;

	@Autowired
	public UserCtrl(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/checkLogIn", method = RequestMethod.POST)
	public ReturnObj checkLogIn(@RequestBody Map<String, Object> reqBody) {
		String userName = "", psd = "";
		Map<String, Object> conMap = new HashMap<>(0);
		Bdf2User user;
		try {
			userName = BaseUtil.object2String(reqBody.get("userName"));
			psd = BaseUtil.object2String(reqBody.get("psd"));
			if (StringUtils.isEmpty(userName)) {
				return ApiReturnUtil.handleDataWithErro("请传入登录名！");
			}
			if (StringUtils.isEmpty(psd)) {
				return ApiReturnUtil.handleDataWithErro("请传入密码！");
			}
			// step 1 : 判断该登录名是否存在
			conMap.put("username", userName);
			// 密码解码
			psd = BaseUtil.Base64Encode(psd);
			psd = BaseUtil.Base64Decode(psd);
			user = userService.getUserByMap(conMap);
			if (user == null) {
				// TODO
			}
			return ApiReturnUtil.handleData(user);
		} catch (Exception e) {
			e.printStackTrace();
			return ApiReturnUtil.handleDataWithErro(e.getMessage());
		}
	}
}
