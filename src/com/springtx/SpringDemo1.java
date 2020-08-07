package com.springtx;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 娴嬭瘯杞处鐨勭幆澧�
 * @author jt
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SpringDemo1 {

	@Resource(name="accountService")
	private AccoutService accountService;
	
	@Test
	public void demo1(){
		accountService.transfer("a", "b", 100d);
	}
}
