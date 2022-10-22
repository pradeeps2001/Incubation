package bank.storagelayer;

import java.util.Map;

import bank.pojo.AccountDetailsPojo;
import bank.pojo.CustomerDetailsPojo;
import bank.pojo.TransactionDetailsPojo;
import bank.pojo.UserDetailsPojo;
import myutil.CustomException;

public interface AdminStorageInterface {

	Map<Long,UserDetailsPojo> showUser(Long... userId) throws CustomException;
	
	Map<Long,Map<Long,AccountDetailsPojo>> showAccounts(Long... customerId) throws CustomException;
	
	Map<Long,Map<Long,TransactionDetailsPojo>> getTransactionDetails(long customerId, Long... accNo) throws CustomException;
	
	void createCustomer(CustomerDetailsPojo customer) throws CustomException;
	
	void createAccount(AccountDetailsPojo account) throws CustomException;
}
