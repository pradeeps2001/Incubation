package bank.runner;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Logger;

import bank.methods.CustomerMethods;
import bank.pojo.AccountDetailsPojo;
import bank.pojo.CustomerDetailsPojo;
import bank.pojo.TransactionDetailsPojo;
import bank.storagelayer.CustomerStorageInterface;
import myutil.CustomException;
import myutil.MyUtil;

public class CustomerRunner {

	private static final Logger logger = Logger.getLogger(CustomerRunner.class.getName());

	public void customerLayer(long userId, String password, List<Long> accList) throws CustomException {
		
		CustomerStorageInterface customer = new CustomerMethods();
		CustomerMethods helper = new CustomerMethods();
		Scanner scan = new Scanner(System.in);
		String decision;
		
		try {
			int accountChoice = MyUtil.checkInt(scan);
			do {
				logger.info("Enter a choice : " 
						+ "\n1. Customer Info" 
						+ "\n2. Account Info" 
						+ "\n3. Recent Transactions"
						+ "\n4. Balance Enquiry"
						+ "\n5. Deposit" 
						+ "\n6. Withdraw" 
						+ "\n7. Transfer");
				int choice = MyUtil.checkInt(scan);
				long accountNo = accList.get(accountChoice - 1);
				switch (choice) {
				case 1: {
					Map<Long, CustomerDetailsPojo> userMap = customer.getCustomerInfo(userId);
					helper.printUserInfo(userMap);
					break;
				}
				case 2: {
					Map<Long, Map<Long, AccountDetailsPojo>> accMap = customer.getAccountDetails(accountNo);
					helper.printAccountInfo(accMap, userId);
					break;
				}
				case 3: {
					Map<Long, Map<Long, TransactionDetailsPojo>> transactionMap = customer.getTransactionDetails(userId, accountNo);
					helper.printTransactionInfo(transactionMap, accountNo);
					break;
				}
				case 4: {
					AccountDetailsPojo balanceObj = helper.getBalance(accountNo);
					logger.info("Your Balance is - " + balanceObj.getBalance());
					break;
				}
				case 5: {
					logger.info("Enter the amount to deposit : ");
					double amount = MyUtil.checkDouble(scan);
					customer.deposit(userId, accountNo, amount);
					logger.info("DEPOSIT SUCCESSFUL");
					break;
				}
				case 6: {
					logger.info("Enter the amount to withdraw : ");
					double amount = MyUtil.checkDouble(scan);
					customer.withdraw(userId, accountNo, amount);
					logger.info("WITHDRAWAL SUCCESSFUL");
					break;
				}
				case 7 :{
					logger.info("Enter the receiver Account No :");
					long receiver = MyUtil.checkLong(scan);
					logger.info("Enter the amount to transfer : ");
					double amount = MyUtil.checkDouble(scan);
					customer.transfer(userId, accountNo, receiver, amount);
					logger.info("TRANSFER SUCCESSFUL.");
					break;
				}
				default:
					System.out.println("No matching case.");
				}
				logger.info("Do you want to continue - Yes (or) No");
				decision = scan.next();
			} while (decision.equalsIgnoreCase("yes")); 
		} catch (CustomException e) {
			e.printStackTrace();
		}
	}

}
