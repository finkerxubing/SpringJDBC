package com.springjdbc;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class JdbcDemo1 {
		@Test
		public void demo1() {
			//�������ӳ�
			DriverManagerDataSource dataSource=new DriverManagerDataSource();
			dataSource.setDriverClassName("com.mysql.jdbc.Driver");
			dataSource.setUrl("jdbc:mysql:///springjdbc?serverTimezone=GMT");
			dataSource.setUsername("root");
			dataSource.setPassword("admin");
			//����JDBCģ��
			JdbcTemplate jdbcTemplate=new  JdbcTemplate(dataSource);
			jdbcTemplate.update("insert into account values(1,?,?)","��ʵ",122d);
		}
}
