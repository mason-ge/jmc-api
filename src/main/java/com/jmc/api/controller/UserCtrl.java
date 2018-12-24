package com.jmc.api.controller;

import java.util.HashMap;
import java.util.Map;

import com.jmc.api.common.Constants;
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

	/**
	 * 登录名密码验证
	 * 
	 * @param reqBody
	 * @return
	 */
	@RequestMapping(value = "/checkLogIn", method = RequestMethod.POST)
	public ReturnObj checkLogIn(@RequestBody Map<String, Object> reqBody) {
		String userName, psd, salt, psdRight;
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
			user = userService.getUserByMap(conMap);
			if (user == null) {
				return ApiReturnUtil.handleDataWithErro("用户不存在！");
			}
			// step 2 : 判断密码是否正确
			// 取出当前用户对应的salt值
			salt = user.getSalt();
			// 取出当前正确的密码(经过SHA1加密的)
			psdRight = user.getPassword();
			// 传入的密码解码
			psd = BaseUtil.Base64Decode(psd);
			// 传入的密码加密
			psd = BaseUtil.bdf2Encrypt(psd, salt);
			if (!psd.equals(psdRight)) {
				return ApiReturnUtil.handleDataWithErro("密码不正确！");
			}
			// step 3 :用户名密码都正确，返回user对象
			return ApiReturnUtil.handleData(user);
		} catch (Exception e) {
			e.printStackTrace();
			return ApiReturnUtil.handleDataWithErro(e.getMessage());
		}
	}

	/**
	 * 注册用户
	 * 
	 * @param reqBody
	 * @return
	 */
	@RequestMapping(value = "/registUser", method = RequestMethod.POST)
	public ReturnObj registUser(@RequestBody Map<String, Object> reqBody) {
		String userName, psd, salt, cname, mobile;
		Map<String, Object> conMap = new HashMap<>(0);
		Bdf2User user;
		try {
			// 登录名
			userName = BaseUtil.object2String(reqBody.get("userName"));
			// 密码
			psd = BaseUtil.object2String(reqBody.get("psd"));
			// 用户名
			cname = BaseUtil.object2String(reqBody.get("cname"));
			// 手机号
			mobile = BaseUtil.object2String(reqBody.get("mobile"));

			// 校验必输
			if (StringUtils.isEmpty(userName)) {
				return ApiReturnUtil.handleDataWithErro("请传入登录名！");
			}
			if (StringUtils.isEmpty(psd)) {
				return ApiReturnUtil.handleDataWithErro("请传入密码！");
			}
			if (StringUtils.isEmpty(cname)) {
				return ApiReturnUtil.handleDataWithErro("请传入用户名！");
			}
			// step 1 :判断用户名是否已存在

			conMap.put("username", userName);
			user = userService.getUserByMap(conMap);
			if (user != null) {
				return ApiReturnUtil.handleDataWithErro("用户已存在！");
			}
			// step 2 :密码解码和加密
			psd = BaseUtil.Base64Decode(psd);
			salt = String.valueOf(BaseUtil.getRandomNum());
			psd = BaseUtil.bdf2Encrypt(psd, salt);

			// step 3 :将注册的用户存入数据库
			user = new Bdf2User();
			user.setUsername(userName);
			user.setPassword(psd);
			user.setSalt(salt);
			user.setCompanyId(Constants.COMPANY_ID);
			user.setAdministrator(0);
			user.setCname(cname);
			user.setEnabled(1);
			user.setMale(1);
			user.setMobile(mobile);
			userService.saveUser(user);

			// step 4 :返回
			return ApiReturnUtil.handleData(user);
		} catch (Exception e) {
			e.printStackTrace();
			return ApiReturnUtil.handleDataWithErro(e.getMessage());
		}
	}
}
