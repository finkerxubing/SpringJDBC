package com.springtx2;
/**
 * 杞处鐨凞AO鐨勬帴鍙�
 * @author jt
 *
 */
public interface AccountDao {
	public void outMoney(String from ,Double money);
	public void inMoney(String to ,Double money);
}
