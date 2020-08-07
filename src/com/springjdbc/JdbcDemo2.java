package com.springjdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.swing.tree.RowMapper;
import javax.swing.tree.TreePath;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.domain.Account;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class JdbcDemo2 {
	@Resource(name="jdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	@Test
	public void demo2() {
		jdbcTemplate.update("insert into account values(null,?,?) ","a3w34s",2121d);
	}
	@Test
	public void demo3(){
		jdbcTemplate.update("update account set name=?,money=? where id=?","asas",121d,2);
	}
	
	@Test
	public void demo4(){
		jdbcTemplate.update("delete from  account  where id=?",3);
	}
	
	@Test
	public void demo5() {
		String name=jdbcTemplate.queryForObject("select name from account where id=?", String.class, 4);
	
	System.out.println(name);
	}
	@Test
	public void demo6() {
		Long count=jdbcTemplate.queryForObject("select count(*) from account", Long.class);
	System.out.println(count);
	}
	
	@Test
	//封装到对象中
	public void demo7() {
		Account account=jdbcTemplate.queryForObject("select * from account where id=?", new MyRowMapper(), 5);
		System.out.println(account);
	}
	class MyRowMapper implements org.springframework.jdbc.core.RowMapper<Account>{

		@Override
		public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			Account account=new Account();
			account.setId(rs.getInt("id"));
			account.setName(rs.getString("name"));
			account.setMoney(rs.getDouble("money"));
			
			return account;
		}

	}
	
	@Test
	public void demo8() {
		List<Account> list=jdbcTemplate.query("select * from account", new  MyRowMapper());
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Account account = (Account) iterator.next();
			System.out.println(account);
			
		}
	}
}
