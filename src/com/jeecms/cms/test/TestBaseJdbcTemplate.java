package com.jeecms.cms.test;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@ContextConfiguration(locations = { "classpath:config/applicationContext.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class TestBaseJdbcTemplate {
	
	
	@Resource(name = "dataSource")
	private DataSource dataSource;

	@Test
	public void queryJdbcData() {
		System.out.println("开始查询数据");
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		System.out.println("通过jdbc查询数据条数："
				+ jdbcTemplate.queryForList("select * from user_info").size());
	}
}
