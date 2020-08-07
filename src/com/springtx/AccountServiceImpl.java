package com.springtx;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * 杞处鐨勪笟鍔″眰鐨勫疄鐜扮被
 * @author jt
 *
 */
public class AccountServiceImpl implements AccoutService {

	// 娉ㄥ叆DAO:
	private AccountDao accountDao;
	
	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}
	
	// 娉ㄥ叆浜嬪姟绠＄悊鐨勬ā鏉�
	private TransactionTemplate trsactionTemplate;

	public void setTrsactionTemplate(TransactionTemplate trsactionTemplate) {
		this.trsactionTemplate = trsactionTemplate;
	}

	@Override
	/**
	 * from锛氳浆鍑鸿处鍙�
	 * to锛氳浆鍏ヨ处鍙�
	 * money锛氳浆璐﹂噾棰�
	 */
	public void transfer(final String from, final String to, final Double money) {
		
		trsactionTemplate.execute(new TransactionCallbackWithoutResult() {
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
				accountDao.outMoney(from, money);
				int d = 1/0;
				accountDao.inMoney(to, money);
			}
		});
		
	}

}
