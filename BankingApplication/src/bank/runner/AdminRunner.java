package bank.runner;

import java.util.Map;
import java.util.Scanner;
import java.util.logging.Logger;

import bank.methods.AdminMethods;
import bank.pojo.AccountDetailsPojo;
import bank.pojo.CustomerDetailsPojo;
import bank.pojo.TransactionDetailsPojo;
import bank.pojo.UserDetailsPojo;
import bank.storagelayer.AdminStorageInterface;
import myutil.CustomException;
import myutil.MyUtil;

public class AdminRunner {

	private static final Logger logger = Logger.getLogger(AdminRunner.class.getName());

	public void adminLayer(long userId, String password) {
		
		AdminStorageInterface admin = new AdminMethods();
		AdminMethods helper = new AdminMethods();
		Scanner scan = new Scanner(System.in);
		String decision;
			do {
				logger.info("Enter a choice : " 
						+ "\n1. Show UserInfo" 
						+ "\n2. Show AccountInfo" 
						+ "\n3. Show Transactions"
						+ "\n4. Create Customer"
						+ "\n5. Create Account"
						+ "\n6. Change Status"
						+ "\n7. ");
				int choice = MyUtil.checkInt(scan);
				try {
				switch (choice) {
				case 1: {
					logger.info("Choose option :"
							+ "\n\n1) To check all users."
							+ "\n2) To check specific user.");
					int option = MyUtil.checkInt(scan);
					switch (option) {
					case 1 :{
						Map<Long, UserDetailsPojo> map = admin.showUser();
						helper.printUserInfo(map);
						break;
					}
						
					case 2 : {
						logger.info("How many User Info do you want to check :");
						int num = MyUtil.checkInt(scan);
						logger.info("Enter the userId's of the users :");
						Map<Long, UserDetailsPojo> map = admin.showUser(MyUtil.getLongInput(scan, num));
						helper.printUserInfo(map);
						break;
					}
						
					default :
						logger.info("Enter a valid choice.");
					}
					break;
				}
				case 2: {
					logger.info("Choose option :"
							+ "\n\n1) Check all accounts."
							+ "\n2) Check specific account.");
					int option = MyUtil.checkInt(scan);
					switch (option) {
					case 1 : {
						Map<Long, Map<Long, AccountDetailsPojo>> map = admin.showAccounts();
						helper.printAccountInfo(map);
						break;
					}
					case 2 : {
						logger.info("No. of user accounts you want to check :");
						int num = MyUtil.checkInt(scan);
						logger.info("Enter the userId's of accounts want to check :");
						Map<Long, Map<Long, AccountDetailsPojo>> map = admin.showAccounts(MyUtil.getLongInput(scan, num));
						helper.printAccountInfo(map);
						break;
					}
					default :
						logger.info("Enter a valid choice.");
					}
					break;
				}
				case 3: {
					logger.info("Enter the Customer ID to check : ");
					int cusId = MyUtil.checkInt(scan);
					logger.info("Choose option :"
							+ "\n\n1) Check all transactions of a user."
							+ "\n2) Check specific account transactions.");
					int option = MyUtil.checkInt(scan);
					switch (option) {
					case 1 : {
						Map<Long, Map<Long, TransactionDetailsPojo>> map = admin.getTransactionDetails(cusId);
						helper.printTransactionInfo(map);
						break;
					}
					case 2 : {
						logger.info("Enter the Account No. you want to check :");
						long acc = MyUtil.checkLong(scan);
						Map<Long, Map<Long, TransactionDetailsPojo>> map = admin.getTransactionDetails(cusId, acc);
						helper.printTransactionInfo(map);
						break;
					}
					default :
						logger.info("Enter a valid choice.");
					}
					break;
				}
				case 4: {
					CustomerDetailsPojo customer = new CustomerDetailsPojo();
					logger.info("Enter the Name :");
					String name = scan.nextLine();
					logger.info("Enter the DOB :");
					String dob = scan.next();
					logger.info("Enter the Mobile No. :");
					String mobile = scan.next();
					logger.info("Enter the Password :");
					String pass = scan.next();
					logger.info("Enter the Aadhaar No. :");
					long aadhar = MyUtil.checkLong(scan);
					logger.info("Enter the PAN No. :");
					String pan = scan.next();
					customer.setUserName(name);
					customer.setDOB(dob);
					customer.setMobileNum(mobile);
					customer.setRole("CUSTOMER");
					customer.setPassword(pass);
					customer.setAadharNum(aadhar);
					customer.setPanNum(pan);
					customer.setStatus("ACTIVE");
					admin.createCustomer(customer);
					logger.info("Customer created successfully.");
					break;
				}
				case 5: {
					AccountDetailsPojo account = new AccountDetailsPojo();
					logger.info("Enter the Customer ID :");
					Long cusId = MyUtil.checkLong(scan);
					logger.info("Enter the Account Type :");
					String type = scan.next();
					logger.info("Enter the Branch :");
					String branch = scan.next();
					logger.info("Enter the Minimum Balance :");
					Double balance = MyUtil.checkDouble(scan);
					account.setCustomerId(cusId);
					account.setAccountType(type);
					account.setBranch(branch);
					account.setBalance(balance);
					account.setStatus("ACTIVE");
					admin.createAccount(account);
					logger.info("Account created successfully.");
					break;
				}
				case 6: {
					
					break;
				}
				case 7 :{
					
					break;
				}
				default:
					System.out.println("No matching case.");
				}
				} catch (CustomException e) {
					e.printStackTrace();
				}
				logger.info("Do you want to logout - Yes (or) No");
				decision = scan.next();
			} while (decision.equalsIgnoreCase("No")); 
	}
}
