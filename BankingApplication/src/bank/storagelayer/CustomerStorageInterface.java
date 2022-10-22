package bank.storagelayer;
	
import java.util.Map;

import bank.pojo.AccountDetailsPojo;
import bank.pojo.CustomerDetailsPojo;
import bank.pojo.TransactionDetailsPojo;
import bank.pojo.UserDetailsPojo;
import myutil.CustomException;
	
public interface CustomerStorageInterface {
	
	AccountDetailsPojo getId(long accNo) throws CustomException;
	
	UserDetailsPojo getLoginDetails(long userId) throws CustomException;
	
	Map<Long,CustomerDetailsPojo> getCustomerInfo(long customerId) throws CustomException;
	
	Map<Long,Map<Long,AccountDetailsPojo>> getAccountDetails(long customerId, Long... accountNo) throws CustomException;
	
	Map<Long,Map<Long,TransactionDetailsPojo>> getTransactionDetails(long customerId, long accNo) throws CustomException;
	
	AccountDetailsPojo getBalance(long accNo) throws CustomException;
	
	void deposit(long userId, long accNo, double amount) throws CustomException;
	
	void withdraw(long userId, long accNo, double amount) throws CustomException;
	
	void transfer(long senderId, long senderAcc, long receiverAcc, double amount) throws CustomException;
	
	void updateTransaction(TransactionDetailsPojo obj) throws CustomException;
	
}	