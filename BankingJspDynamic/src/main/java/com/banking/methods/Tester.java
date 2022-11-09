package com.banking.methods;

import java.util.Map;

import com.banking.localcache.StorageLayer;
import com.banking.pojo.AccountDetails;
import com.banking.pojo.CustomerDetails;
import com.banking.pojo.RequestDetails;
import com.banking.pojo.TransactionDetails;
import com.banking.pojo.UserDetails;

import myutil.CustomException;

public class Tester {
public static void main(String[] args) {
	StorageLayer storage = new StorageLayer();
	AdminOperations admin = new AdminOperations();
	CustomerOperations customer = new CustomerOperations();
	
	try {
		storage.setAllData();
	} catch (CustomException e1) {
		e1.printStackTrace();
	}
	
	Map<Long, UserDetails> userDetails = storage.getUserDetails();
	Map<Long,CustomerDetails> customerDetails = storage.getCustomerDetails();
	Map<Long,Map<Long,AccountDetails>> accountDetails = storage.getAccountDetails();
	Map<Long,Map<Long,TransactionDetails>> transactionDetails = storage.getTransactionDetails();
	Map<Long,RequestDetails> requestDetails = storage.getRequestDetails();
	
	System.out.println(userDetails.size());
	System.out.println(customerDetails.size());
	System.out.println(accountDetails.size());
	System.out.println(transactionDetails.size());
	System.out.println(requestDetails.size());
	
	try {
		boolean s = admin.isAccountActive(38057650581L);
		System.out.println(s);
	} catch (CustomException e) {
		e.getMessage();
	}
}
	
}
