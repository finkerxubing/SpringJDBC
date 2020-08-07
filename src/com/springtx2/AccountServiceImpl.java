package com.springtx2;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * 杞处鐨勪笟鍔″眰鐨勫疄鐜扮被
 * @author jt
 *
 */
public class AccountServiceImpl implements AccountService {

	// 娉ㄥ叆DAO:
	private AccountDao accountDao;
	
	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}
	
	@Override
	/**
	 * from锛氳浆鍑鸿处鍙�
	 * to锛氳浆鍏ヨ处鍙�
	 * money锛氳浆璐﹂噾棰�
	 */
	public void transfer( String from,  String to,  Double money) {
		
		accountDao.outMoney(from, money);
//		int d = 1/0;
		accountDao.inMoney(to, money);
		
	}

}
