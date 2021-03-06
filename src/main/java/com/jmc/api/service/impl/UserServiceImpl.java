package com.jmc.api.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.jmc.api.dao.BaseDao;
import com.jmc.api.entity.Bdf2User;
import com.jmc.api.service.UserService;

/**
 * @Description:人员信息接口实现
 * @Author: mason_ge
 * @Date: 16:26 2018/12/21
 */
@Service("userServiceImpl")
public class UserServiceImpl extends BaseDao implements UserService {
	@Override
	public Bdf2User getUserByMap(Map<String, Object> map) {
		Map<String, Object> conMap = new HashMap<>(0);
		String fieldName, fieldValue, eachKey;
		Object eachValue;
		StringBuilder sb = new StringBuilder();
		try {
			sb.append("from Bdf2User t where 1=1 ");
			for (Map.Entry<String, Object> entry : map.entrySet()) {
				eachKey = entry.getKey();
				eachValue = entry.getValue();
				if (!StringUtils.isEmpty(eachValue)) {
					sb.append(" and t.").append(eachKey).append(" =:").append(eachKey);
					conMap.put(eachKey, eachValue);
				}
			}
			return this.queryEntity(sb.toString(), conMap);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public void saveUser(Bdf2User user) {
		try {
			user.setCreateDate(new Date());
			this.save(user);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
