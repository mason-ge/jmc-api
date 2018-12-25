package com.jmc.api.service.impl;

import com.jmc.api.common.Constants;
import com.jmc.api.common.Page;
import com.jmc.api.dao.BaseDao;
import com.jmc.api.service.ProdService;
import com.jmc.api.util.BaseUtil;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:商品接口实现
 * @Author: mason_ge
 * @Date: 11:41 2018/12/18
 */
@Service("prodServiceImpl")
public class ProdServiceImpl extends BaseDao implements ProdService {
	@Override
	public List<Map<String, Object>> getProdList(Map<String, Object> param, Page pg) {
		StringBuilder sb = new StringBuilder();
		Map<String, Object> conMap = new HashMap<>(0);
		String firstCatg, secCatg;
		try {
			sb.append(" select TBL.* from (																 ");
			sb.append(" SELECT                                                                           ");
			sb.append(" t.*,                                                                             ");
			sb.append(" (select f.FILE_HTTP_PATH from sys_file f  										 ");
			sb.append(" where f.ATTR1 = t.PROD_CODE order by f.CREATED_D desc limit 1) as img			 ");
			sb.append(" FROM                                                                           	 ");
			sb.append(" prod_base_info t                                                                 ");
			sb.append(" where 1=1																		 ");
			sb.append(" and t.del_flg = '0'																 ");
			sb.append("and t.client = :client 															 ");
			if (param != null && !param.isEmpty()) {
				firstCatg = BaseUtil.object2String(param.get("firstCatg"));
				secCatg = BaseUtil.object2String(param.get("secCatg"));
				// 控制层已经做了控制，客户端号不能为空
				conMap.put("client", param.get("client"));
				// 判断是否是所有品类
				if (!Constants.ALL_CATEGORY.equals(firstCatg)) {
					// 判断是否是一级品类
					if ("".equals(secCatg) || secCatg == null) {
						sb.append("and t.first_catg = :firstCatg	");
						conMap.put("firstCatg", firstCatg);
					} else {
						sb.append("and t.first_catg = :firstCatg	");
						sb.append("and t.sec_catg = :secCatg		");
						conMap.put("firstCatg", firstCatg);
						conMap.put("secCatg", secCatg);
					}
				}
			}
			sb.append(" )TBL where 1=1 ");
			sb.append("and TBL.img is not null 															 ");
			sb.append("and TBL.img <> '' 															 	 ");
			return this.queryPageListBySql(sb.toString(), conMap, pg);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
