package bank.runner;

import java.util.List;

import java.util.Map;
import java.util.Scanner;
import java.util.logging.Logger;

import bank.methods.CustomerMethods;
import bank.pojo.AccountDetailsPojo;
import bank.pojo.UserDetailsPojo;
import bank.storagelayer.CustomerStorageInterface;
import myutil.CustomException;
import myutil.MyUtil;

public class Tester {

	private static final Logger logger = Logger.getLogger(Tester.class.getName());
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		CustomerStorageInterface cusStorageHelper = new CustomerMethods();
		CustomerMethods cusHelper = new CustomerMethods();
		CustomerRunner customer = new CustomerRunner();
		AdminRunner admin = new AdminRunner();
		
		logger.info("Enter your login details :"
				+ "\nEnter your ID :");
		long id = MyUtil.checkLong(scan);
		logger.info("Enter your password :");
		String password = scan.next();
		try {
		UserDetailsPojo obj = cusStorageHelper.getLoginDetails(id);
		Map<Long, Map<Long, AccountDetailsPojo>> accountMap = cusStorageHelper.getAccountDetails(id);

		long userId = obj.getUserId();
		String pass = obj.getPassword();
		String role = obj.getRole();
//		String status = obj.getStatus();
		if (id == userId && password.equals(pass)) {
			logger.info("Logged in Successfully...\n\n"
					+ "+-------------------------------+ \n"
					+ "| Welcome to Lucas Federal Bank |\n"
					+ "+-------------------------------+ \n\n"
					+ "Hi " + obj.getUserName());
			if(role.equals("ADMIN")) {
				admin.adminLayer(userId, password);
			}
			else if (role.equals("CUSTOMER")) {
//				if(status.equals("ACTIVE")) {
					logger.info("Choose the account : ");
					List<Long> accList = cusHelper.printAccounts(accountMap,userId);
					int len = accList.size();
					for (int i = 0; i < len; i++) {
						System.out.println((i+1) + ") " + accList.get(i));
					}
//				}
					customer.customerLayer(userId, password, accList);
			}
		} else {
			logger.info("Login Credentials Invalid..." + "\nTry Again.");
		}
		}catch (CustomException e) {
			e.printStackTrace();
		}
	}
}
