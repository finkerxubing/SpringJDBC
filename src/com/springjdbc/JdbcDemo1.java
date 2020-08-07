package com.springjdbc;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class JdbcDemo1 {
		@Test
		public void demo1() {
			//创建连接池
			DriverManagerDataSource dataSource=new DriverManagerDataSource();
			dataSource.setDriverClassName("com.mysql.jdbc.Driver");
			dataSource.setUrl("jdbc:mysql:///springjdbc?serverTimezone=GMT");
			dataSource.setUsername("root");
			dataSource.setPassword("admin");
			//创建JDBC模板
			JdbcTemplate jdbcTemplate=new  JdbcTemplate(dataSource);
			jdbcTemplate.update("insert into account values(1,?,?)","扎实",122d);
		}
}
