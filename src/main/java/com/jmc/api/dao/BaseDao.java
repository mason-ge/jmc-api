package com.jmc.api.dao;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.jmc.api.common.CustomBeanResultTransformer;
import com.jmc.api.common.CustomMapResultTransformer;
import com.jmc.api.common.Page;
import com.jmc.api.util.BaseUtil;

/**
 * @Description:基础抽象类
 * @Author: mason_ge
 * @Date: 15:17 2018/12/18
 */
@Transactional(rollbackFor = Exception.class)
@SuppressWarnings("unchecked")
public abstract class BaseDao extends HibernateDaoSupport {

	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	/**
	 * 获取Session
	 * 
	 * @return
	 */
	protected Session getSession() {
		return Objects.requireNonNull(this.getSessionFactory()).getCurrentSession();
	}

	/**
	 * HQL查询单个实体
	 * 
	 * @param hql 查询语句
	 * @param     <T>
	 * @return
	 */
	public <T> T queryEntity(String hql) {
		try {
			Query query = this.getSession().createQuery(hql);
			return (T) query.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

	/**
	 * HQL查询单个实体，数组传参
	 * 
	 * @param hql  查询语句
	 * @param objs 查询参数
	 * @param      <T>
	 * @return
	 */
	public <T> T queryEntity(String hql, Object[] objs) {
		try {
			Query query = this.getSession().createQuery(hql);
			if (objs != null) {
				for (int i = 0; i < objs.length; i++) {
					query.setParameter(i, objs[i]);
				}
			}
			return (T) query.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

	/**
	 * HQL查询单个实体，MAP传参
	 * 
	 * @param hql 查询语句
	 * @param map 查询参数
	 * @param     <T>
	 * @return
	 */
	public <T> T queryEntity(String hql, Map<String, Object> map) {
		try {
			Query query = this.getSession().createQuery(hql);
			for (Map.Entry<String, Object> entry : map.entrySet()) {
				if (entry.getValue() instanceof Collection<?>) {
					query.setParameterList(entry.getKey(), (Collection<?>) entry.getValue());
				} else {
					query.setParameter(entry.getKey(), entry.getValue());
				}
			}
			return (T) query.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

	/**
	 * HQL查询实体列表
	 * 
	 * @param hql 查询语句
	 * @param     <T>
	 * @return
	 */
	public <T> List<T> queryEntityList(String hql) {
		try {
			Query query = this.getSession().createQuery(hql);
			return query.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

	/**
	 * HQL查询实体列表,数组传参
	 * 
	 * @param hql  查询语句
	 * @param objs 查询参数
	 * @param      <T>
	 * @return
	 */
	public <T> List<T> queryEntityList(String hql, Object[] objs) {
		try {
			Query query = this.getSession().createQuery(hql);
			if (objs != null) {
				for (int i = 0; i < objs.length; i++) {
					query.setParameter(i, objs[i]);
				}
			}
			return query.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

	/**
	 * HQL查询实体列表，MAP传参
	 * 
	 * @param hql 查询语句
	 * @param map 查询参数
	 * @param     <T>
	 * @return
	 */
	public <T> List<T> queryEntityList(String hql, Map<String, Object> map) {
		try {
			Query query = this.getSession().createQuery(hql);
			for (Map.Entry<String, Object> entry : map.entrySet()) {
				if (entry.getValue() instanceof Collection<?>) {
					query.setParameterList(entry.getKey(), (Collection<?>) entry.getValue());
				} else {
					query.setParameter(entry.getKey(), entry.getValue());
				}
			}
			return query.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

	/**
	 * HQL分页查询实体列表，数组传参
	 * 
	 * @param hql  查询语句
	 * @param objs 查询参数
	 * @param pg   分页对象
	 * @param      <T>
	 * @return
	 */
	public <T> List<T> queryEntityList(String hql, Object[] objs, Page pg) {
		int firstResult, maxResult, totalCount;
		try {
			String countQuery = "select count(*) " + hql.substring(hql.indexOf("from "));
			totalCount = ((Long) this.queryEntityList(countQuery, objs).listIterator().next()).intValue();
			pg.setTotalRows(totalCount);
			Query query = this.getSession().createQuery(hql);
			if (objs != null) {
				for (int i = 0; i < objs.length; i++) {
					query.setParameter(i, objs[i]);
				}
			}
			query.setFirstResult((pg.getPageNo() - 1) * pg.getPageSize());
			query.setMaxResults(pg.getPageSize());
			return query.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

	/**
	 * HQL分页查询实体列表，MAP传参
	 * 
	 * @param hql 查询语句
	 * @param map 查询参数
	 * @param pg  分页对象
	 * @param     <T>
	 * @return
	 */
	public <T> List<T> queryEntityList(String hql, Map<String, Object> map, Page pg) {
		int firstResult, maxResult, totalCount;
		try {
			String countQuery = "select count(*) " + hql.substring(hql.indexOf("from "));
			totalCount = ((Long) this.queryEntityList(countQuery, map).listIterator().next()).intValue();
			pg.setTotalRows(totalCount);
			Query query = this.getSession().createQuery(hql);
			for (Map.Entry<String, Object> entry : map.entrySet()) {
				if (entry.getValue() instanceof Collection<?>) {
					query.setParameterList(entry.getKey(), (Collection<?>) entry.getValue());
				} else {
					query.setParameter(entry.getKey(), entry.getValue());
				}
			}
			query.setFirstResult((pg.getPageNo() - 1) * pg.getPageSize());
			query.setMaxResults(pg.getPageSize());
			return query.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

	/**
	 * SQL单个实体查询，数组传参
	 *
	 * @param sql  查询语句
	 * @param objs 查询参数
	 * @param clz  查询结果封装实体类
	 * @return T 查询结果
	 */
	public <T> T queryEntityBySql(String sql, Object[] objs, Class<?> clz) {
		SQLQuery sqlQuery;
		try {
			sqlQuery = this.getSession().createSQLQuery(sql);

			if (objs != null) {
				for (int i = 0; i < objs.length; i++) {
					sqlQuery.setParameter(i, objs[i]);
				}
			}

			sqlQuery.setResultTransformer(new CustomBeanResultTransformer(clz));
			return (T) sqlQuery.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

	/**
	 * SQL单个实体查询，支持Map传参
	 *
	 * @param sql 查询语句
	 * @param map 查询参数
	 * @param clz 查询结果封装实体类
	 * @return T 查询结果
	 */
	public <T> T queryEntityBySql(String sql, Map<String, Object> map, Class<?> clz) {
		SQLQuery sqlQuery;
		try {
			sqlQuery = this.getSession().createSQLQuery(sql);

			for (Map.Entry<String, Object> entry : map.entrySet()) {
				sqlQuery.setParameter(entry.getKey(), entry.getValue());
			}

			sqlQuery.setResultTransformer(new CustomBeanResultTransformer(clz));
			return (T) sqlQuery.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

	/**
	 * SQL单个对象MAP查询，数组传参
	 *
	 * @param sql  查询语句
	 * @param objs 查询参数
	 * @return Map<String, Object> 查询结果
	 */
	public Map<String, Object> queryMapBySql(String sql, Object[] objs) {
		Map<String, Object> result;
		SQLQuery sqlQuery;
		try {
			sqlQuery = this.getSession().createSQLQuery(sql);
			if (objs != null) {
				for (int i = 0; i < objs.length; i++) {
					sqlQuery.setParameter(i, objs[i]);
				}
			}
			sqlQuery.setResultTransformer(new CustomMapResultTransformer());
			result = (Map<String, Object>) sqlQuery.uniqueResult();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

	/**
	 * SQL单个对象MAP查询，Map传参
	 *
	 * @param query 查询语句
	 * @param map   查询参数
	 * @return Map<String, Object> 查询结果
	 */
	public Map<String, Object> queryMapBySql(final String query, Map<String, Object> map) {
		Map<String, Object> result;
		SQLQuery sqlQuery;
		try {
			sqlQuery = this.getSession().createSQLQuery(query);
			for (Map.Entry<String, Object> entry : map.entrySet()) {
				sqlQuery.setParameter(entry.getKey(), entry.getValue());
			}
			sqlQuery.setResultTransformer(new CustomMapResultTransformer());
			result = (Map<String, Object>) sqlQuery.uniqueResult();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

	/**
	 * SQL分页查询，Map传参
	 *
	 * @param sql  查询语句
	 * @param map  查询参数
	 * @param page 分页对象
	 * @return List<Map<String, Object>>
	 */
	public List<Map<String, Object>> queryPageListBySql(String sql, Map<String, Object> map, Page page) {
		String countQuery = "select count(1) from (%s) countQuery";
		SQLQuery sqlQuery, countSqlQuery;
		List<Map<String, Object>> result;
		int firstResult, maxResult, totalCount;
		try {
			countQuery = String.format(countQuery, sql);
			sqlQuery = this.getSession().createSQLQuery(sql);
			countSqlQuery = this.getSession().createSQLQuery(countQuery);
			firstResult = (page.getPageNo() - 1) * page.getPageSize();
			maxResult = page.getPageSize();

			for (Map.Entry<String, Object> entry : map.entrySet()) {
				sqlQuery.setParameter(entry.getKey(), entry.getValue());
				countSqlQuery.setParameter(entry.getKey(), entry.getValue());
			}

			sqlQuery.setFirstResult(firstResult);
			sqlQuery.setMaxResults(maxResult);
			sqlQuery.setResultTransformer(new CustomMapResultTransformer());

			result = sqlQuery.list();
			totalCount = BaseUtil.obj2int(countSqlQuery.uniqueResult());
			page.setTotalRows(totalCount);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * SQL分页查询，数组传参
	 *
	 * @param sql  查询语句
	 * @param objs 查询参数
	 * @param page 分页对象
	 * @return List<Map<String, Object>>
	 */
	public List<Map<String, Object>> queryPageListBySql(String sql, Object[] objs, Page page) {
		String countQuery = "select count(1) from (%s) countQuery";
		SQLQuery sqlQuery, countSqlQuery;
		List<Map<String, Object>> result;
		int firstResult, maxResult, totalCount;
		try {
			countQuery = String.format(countQuery, sql);
			sqlQuery = this.getSession().createSQLQuery(sql);
			countSqlQuery = this.getSession().createSQLQuery(countQuery);
			firstResult = (page.getPageNo() - 1) * page.getPageSize();
			maxResult = page.getPageSize();

			for (int index = 0; index < objs.length; index++) {
				sqlQuery.setParameter(index, objs[index]);
				countSqlQuery.setParameter(index, objs[index]);
			}

			sqlQuery.setFirstResult(firstResult);
			sqlQuery.setMaxResults(maxResult);
			sqlQuery.setResultTransformer(new CustomMapResultTransformer());

			result = sqlQuery.list();
			totalCount = BaseUtil.obj2int(countSqlQuery.uniqueResult());
			page.setTotalRows(totalCount);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * SQL分页查询，数组传参，封装实体
	 *
	 * @param sql  查询语句
	 * @param objs 查询参数
	 * @param page 分页对象
	 * @param clz  查询结果封装实体类
	 * @return List<T>
	 */
	public <T> List<T> queryPageListBySql(String sql, Object[] objs, Page page, Class<?> clz) {
		String countQuery = "select count(1) from (%s) countQuery";
		SQLQuery sqlQuery, countSqlQuery;
		List<T> result;
		int firstResult, maxResult, totalCount;
		try {
			countQuery = String.format(countQuery, sql);
			sqlQuery = this.getSession().createSQLQuery(sql);
			countSqlQuery = this.getSession().createSQLQuery(countQuery);
			firstResult = (page.getPageNo() - 1) * page.getPageSize();
			maxResult = page.getPageSize();

			for (int index = 0; index < objs.length; index++) {
				sqlQuery.setParameter(index, objs[index]);
				countSqlQuery.setParameter(index, objs[index]);
			}

			sqlQuery.setFirstResult(firstResult);
			sqlQuery.setMaxResults(maxResult);
			sqlQuery.setResultTransformer(new CustomBeanResultTransformer(clz));

			result = sqlQuery.list();
			totalCount = BaseUtil.obj2int(countSqlQuery.uniqueResult());
			page.setTotalRows(totalCount);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * SQL分页查询，MAP传参，封装实体
	 *
	 * @param sql  查询语句
	 * @param map  查询参数
	 * @param page 分页对象
	 * @param clz  查询结果封装实体类
	 * @return List<T>
	 */
	public <T> List<T> queryPageListBySql(String sql, Map<String, Object> map, Page page, Class<?> clz) {
		String countQuery = "select count(1) from (%s) countQuery";
		SQLQuery sqlQuery, countSqlQuery;
		List<T> result;
		int firstResult, maxResult, totalCount;
		try {
			countQuery = String.format(countQuery, sql);
			sqlQuery = this.getSession().createSQLQuery(sql);
			countSqlQuery = this.getSession().createSQLQuery(countQuery);
			firstResult = (page.getPageNo() - 1) * page.getPageSize();
			maxResult = page.getPageSize();

			for (Map.Entry<String, Object> entry : map.entrySet()) {
				sqlQuery.setParameter(entry.getKey(), entry.getValue());
				countSqlQuery.setParameter(entry.getKey(), entry.getValue());
			}

			sqlQuery.setFirstResult(firstResult);
			sqlQuery.setMaxResults(maxResult);
			sqlQuery.setResultTransformer(new CustomBeanResultTransformer(clz));

			result = sqlQuery.list();
			totalCount = BaseUtil.obj2int(countSqlQuery.uniqueResult());
			page.setTotalRows(totalCount);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * 保存Hibernate实体
	 * 
	 * @param entity Hibernate实体
	 * @param        <T>
	 */
	public <T> void save(T entity) {
		try {
			if (this.getHibernateTemplate() != null) {
				this.getHibernateTemplate().save(entity);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 保存Hibernate实体列表
	 * 
	 * @param entities Hibernate实体列表
	 * @param          <T>
	 */
	public <T> void saveAll(List<T> entities) {
		for (T entity : entities) {
			this.save(entity);
		}
	}

	/**
	 * 保存或更新Hibernate实体
	 * 
	 * @param entity
	 * @param        <T>
	 */
	public <T> void saveOrUpdate(T entity) {
		try {
			if (this.getHibernateTemplate() != null) {
				this.getHibernateTemplate().saveOrUpdate(entity);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

	/**
	 * 更新Hibernate实体
	 * 
	 * @param entity
	 * @param        <T>
	 */
	public <T> void update(T entity) {
		try {
			if (this.getHibernateTemplate() != null) {
				this.getHibernateTemplate().update(entity);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

	/**
	 * 更新Hibernate实体列表
	 * 
	 * @param entities
	 * @param          <T>
	 */
	public <T> void updateAll(List<T> entities) {
		for (T entity : entities) {
			this.update(entity);
		}
	}

	/**
	 * 删除Hibernate实体
	 *
	 * @param entity Hibernate实体
	 */
	public <T> void delete(T entity) {
		try {
			if (this.getHibernateTemplate() != null) {
				this.getHibernateTemplate().delete(entity);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * 删除Hibernate实体列表
	 *
	 * @param entities Hibernate实体列表
	 */
	public <T> void deleteAll(List<T> entities) {
		for (T entity : entities) {
			this.delete(entity);
		}
	}

	/**
	 * hql更新数据库实体，支持更新、删除，返回成功条数
	 *
	 * @param hql
	 * @param parameter
	 * @return
	 */
	public int excute(String hql, Map<String, Object> parameter) {
		int result;
		Query hqlQuery;
		try {
			hqlQuery = this.getSession().createQuery(hql);
			for (Map.Entry<String, Object> entry : parameter.entrySet()) {
				if (entry.getValue() instanceof Collection) {
					hqlQuery.setParameterList(entry.getKey(), (Collection<?>) entry.getValue());
				} else {
					hqlQuery.setParameter(entry.getKey(), entry.getValue());
				}
			}
			result = hqlQuery.executeUpdate();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

	/**
	 * hql更新数据库实体，支持更新、删除，返回成功条数
	 *
	 * @param hql
	 * @param parameter
	 * @return
	 */
	public int excute(String hql, Object[] parameter) {
		int result;
		Query hqlQuery;
		try {
			hqlQuery = this.getSession().createQuery(hql);
			for (int index = 0; index < parameter.length; index++) {
				hqlQuery.setParameter(index, parameter[index]);
			}

			result = hqlQuery.executeUpdate();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

	/**
	 * sql更新数据库实体，支持更新、删除，返回成功条数
	 *
	 * @param query
	 * @param map
	 * @return
	 */
	public int excuteBySql(String query, Map<String, Object> map) {
		int result;
		SQLQuery sqlQuery;
		try {
			sqlQuery = this.getSession().createSQLQuery(query);

			for (Map.Entry<String, Object> entry : map.entrySet()) {
				sqlQuery.setParameter(entry.getKey(), entry.getValue());
			}
			result = sqlQuery.executeUpdate();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

	/**
	 * sql更新数据库实体，支持更新、删除，返回成功条数
	 *
	 * @param query
	 * @param objs
	 * @return
	 */
	public int excuteBySql(final String query, Object[] objs) {
		int result;
		SQLQuery sqlQuery;
		try {
			sqlQuery = this.getSession().createSQLQuery(query);
			for (int index = 0; index < objs.length; index++) {
				sqlQuery.setParameter(index, objs[index]);
			}
			result = sqlQuery.executeUpdate();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}
}
