package com.jmc.api.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.jmc.api.dao.BaseDao;
import com.jmc.api.entity.SysEnumv;
import com.jmc.api.service.EnumService;

/**
 * @Description:枚举接口实现
 * @Author: mason_ge
 * @Date: 14:35 2018/12/21
 */
@Service("enumServiceImpl")
public class EnumServiceImpl extends BaseDao implements EnumService {
	@Override
	public List<SysEnumv> findPlejByEnumvCode(String enumvDesc) {
		Map<String, Object> conMap = new HashMap<>(1);
		try {
			String hql = "from SysEnumv t where 1=1 ";
			hql += "and t.deletedFlag = '0' ";
			hql += "and t.enumId = (select enumId from ";
			hql += "SysEnum where enumCode = 'PLEJ' and deletedFlag = '0') ";
			hql += "and t.enumvDesc = :enumvDesc";
			conMap.put("enumvDesc", enumvDesc);
			return this.queryEntityList(hql, conMap);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<SysEnumv> findEnumvByEnumCode(String enumCode) {
		Object[] objs = new Object[1];
		objs[0] = enumCode;
		try {
			String hql = "from SysEnumv where enumId = (select enumId from SysEnum where enumCode = ? and deletedFlag = '0')"
					+ " and deletedFlag = '0' ";
			hql += " order by orderNo asc";
			return this.queryEntityList(hql, objs);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
