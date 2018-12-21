package com.jmc.api.config;

import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description:hibernate配置
 * @Author: mason_ge
 * @Date: 17:49 2018/12/13
 */

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@Configuration
public class HibernateConfig {

//	@Bean
//	public HibernateTransactionManager transactionManager(HibernateEntityManagerFactory hemf) {
//		return new HibernateTransactionManager(hemf.getSessionFactory());
//	}

	@Bean
	public SessionFactory sessionFactory(HibernateEntityManagerFactory hemf) {
		return hemf.getSessionFactory();
	}
}
