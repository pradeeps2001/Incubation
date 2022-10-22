package bank.methods;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import bank.pojo.AccountDetailsPojo;
import bank.pojo.CustomerDetailsPojo;
import bank.pojo.TransactionDetailsPojo;
import bank.pojo.UserDetailsPojo;
import bank.storagelayer.CustomerStorageInterface;
import myutil.CustomException;
import myutil.MyUtil;

public class CustomerMethods implements CustomerStorageInterface {

	private final String url = "jdbc:mysql://localhost/Lucas_Federal_Bank";
	private final String user = "root";
	private final String password = "Root@123";

	private Connection getConnection() throws CustomException {
		try {
			Connection connection = DriverManager.getConnection(url, user, password);
			return connection;
		} catch(SQLException e) {
			throw new CustomException("Error occured while establishing connection.", e);
		}
	}

	// login
	@Override
	public UserDetailsPojo getLoginDetails(long id) throws CustomException {

		String query = "SELECT * FROM USER_DETAILS WHERE USER_ID = ?";
		UserDetailsPojo obj = new CustomerDetailsPojo();

		try (PreparedStatement prepStat = getConnection().prepareStatement(query);) {
			prepStat.setLong(1, id);
			try (ResultSet rSet = prepStat.executeQuery();) {
				obj = loginPrintRSet(rSet);
			}
		} catch (SQLException e) {
			throw new CustomException("Error occured while execution of prepared statement." + e);
		}
		return obj;
	}

	public UserDetailsPojo loginPrintRSet(ResultSet rSet) throws CustomException {

		UserDetailsPojo obj = new CustomerDetailsPojo();

		try {
			while(rSet.next()) {
				obj.setUserId(rSet.getInt("USER_ID"));
				obj.setUserName(rSet.getString("NAME"));
				obj.setRole(rSet.getString("ROLE"));
//				obj.setStatus(rSet.getString("STATUS"));
				obj.setPassword(rSet.getString("PASSWORD"));
			}

		} catch (SQLException e) {
			throw new CustomException("Error occured." , e);
		}
		return obj;
	}

	// user info
	@Override
	public Map<Long,CustomerDetailsPojo> getCustomerInfo(long id) throws CustomException{

		String query = "SELECT USER_DETAILS.*,CUSTOMER_DETAILS.* FROM USER_DETAILS JOIN CUSTOMER_DETAILS "
				+ "ON USER_DETAILS.USER_ID=CUSTOMER_DETAILS.CUSTOMER_ID WHERE USER_ID = ?";
		Map<Long,CustomerDetailsPojo> map = new LinkedHashMap<>();
		
		try (PreparedStatement prepStat = getConnection().prepareStatement(query);){
			prepStat.setLong(1, id);
			try (ResultSet rSet = prepStat.executeQuery();){
				map = userPrintRSet(rSet);
			}
		} catch (SQLException e) {
			throw new CustomException("Error occurred while execution of prepared statement." , e);
		}
		return map;
	}

	public Map<Long,CustomerDetailsPojo> userPrintRSet(ResultSet rSet) throws CustomException {

		
		Map<Long,CustomerDetailsPojo> map = new LinkedHashMap<>();

		try {
			while(rSet.next()) {
				CustomerDetailsPojo obj = new CustomerDetailsPojo();
				obj.setUserId(rSet.getLong(1));
				obj.setUserName(rSet.getString(2));
				obj.setDOB(rSet.getString(3));
				obj.setMobileNum(rSet.getString(4));
				obj.setRole(rSet.getString(5));
				obj.setPassword(rSet.getString(6));
				obj.setAadharNum(rSet.getLong(7));
				obj.setPanNum(rSet.getString(8));
				obj.setStatus(rSet.getString(9));
				map.put(rSet.getLong(1), obj);
			}

		} catch (SQLException e) {
			throw new CustomException("Error occured." , e);
		}
		return map;
	}

	public void printUserInfo(Map<Long,CustomerDetailsPojo> input) throws CustomException {

		MyUtil.checkNull(input);

		Iterator<CustomerDetailsPojo> itr = input.values().iterator();
		while(itr.hasNext()) {
			CustomerDetailsPojo obj = itr.next();
			System.out.println("_______________________________________________________________________________________________________________\n");
			System.out.println("USER_ID\t- " + obj.getUserId());
			System.out.println("NAME\t- " + obj.getUserName());
			System.out.println("DOB\t- " + obj.getDOB());
			System.out.println("MOBILE\t- " + obj.getMobileNum());
			System.out.println("ROLE\t- " + obj.getRole());
			System.out.println("AADHAAR\t- " + obj.getAadharNum());
			System.out.println("PAN\t- " + obj.getPanNum());
			System.out.println("STATUS\t- " + obj.getStatus());
			System.out.println("_______________________________________________________________________________________________________________");
		}
	}

	// account info
	@Override
	public Map<Long,Map<Long,AccountDetailsPojo>> getAccountDetails(long customerId, Long... accountNo) throws CustomException {
		
		Map<Long,Map<Long,AccountDetailsPojo>> map = new LinkedHashMap<>();
		int len = accountNo.length;
		
		if(len == 0) {
			String query = "SELECT * FROM ACCOUNT_DETAILS WHERE CUSTOMER_ID = ?";
			try(PreparedStatement prepStat = getConnection().prepareStatement(query)){
				prepStat.setLong(1, customerId);
				try (ResultSet rSet = prepStat.executeQuery();){
					map = accountPrintRSet(rSet,map);
				}
			} catch (SQLException e) {
				throw new CustomException("Error occured while establishing connection.", e);
			}
		} else {
		String query = "SELECT * FROM ACCOUNT_DETAILS WHERE CUSTOMER_ID = ? AND ACCOUNT_NO = ?";
		try(PreparedStatement prepStat = getConnection().prepareStatement(query)){
			prepStat.setLong(1, customerId);
			for(Long id : accountNo) {
				prepStat.setLong(2, id);
				try (ResultSet rSet = prepStat.executeQuery();){
					map = accountPrintRSet(rSet,map);
				}
			}
		} catch (SQLException e) {
			throw new CustomException("Error occured while establishing connection.", e);
		}
		}
		return map;
	}

	public Map<Long,Map<Long,AccountDetailsPojo>> accountPrintRSet(ResultSet rSet, Map<Long,Map<Long,AccountDetailsPojo>> inputMap) throws CustomException {

		Map<Long,AccountDetailsPojo> innerMap = new LinkedHashMap<>();

		try {
			while(rSet.next()) {
				AccountDetailsPojo obj = new AccountDetailsPojo();
				obj.setCustomerId(rSet.getLong(1));
				obj.setAccountNo(rSet.getLong(2));
				obj.setAccountType(rSet.getString(3));
				obj.setBranch(rSet.getString(4));
				obj.setBalance(rSet.getDouble(5));
				obj.setStatus(rSet.getString(6));
				innerMap.put(rSet.getLong(2), obj);
				inputMap.put(rSet.getLong(1), innerMap);
			}

		} catch (SQLException e) {
			throw new CustomException("Error occured." , e);
		}
		return inputMap;
	}

	public void printAccountInfo(Map<Long,Map<Long,AccountDetailsPojo>> input, long id) throws CustomException {

		MyUtil.checkNull(input);

		Map<Long,AccountDetailsPojo> innerMap = input.get(id);
		for(Map.Entry<Long,AccountDetailsPojo> entry : innerMap.entrySet()) {
			AccountDetailsPojo obj = entry.getValue();
			System.out.println("_______________________________________________________________________________________________________________\n");
			System.out.println("CUSTOMER_ID\t- " + obj.getCustomerId());
			System.out.println("ACCOUNT_NO\t- " + obj.getAccountNo());
			System.out.println("ACCOUNT_TYPE\t- " + obj.getAccountType());
			System.out.println("BRANCH\t\t- " + obj.getBranch());
			System.out.println("BALANCE\t\t- " + obj.getBalance());
			System.out.println("ACCOUNT STATUS\t- " + obj.getStatus());
			System.out.println("_______________________________________________________________________________________________________________");
		}
	}

	// transaction details
	@Override
	public Map<Long,Map<Long,TransactionDetailsPojo>> getTransactionDetails(long customerId, long accNo) throws CustomException {
		
		String query = "SELECT * FROM TRANSACTION_DETAILS WHERE CUSTOMER_ID = ? AND ACCOUNT_NO = ? ORDER BY TIME DESC limit 5";
		Map<Long,Map<Long,TransactionDetailsPojo>> map = new LinkedHashMap<>();
		
		try (PreparedStatement prepStat = getConnection().prepareStatement(query);){
			prepStat.setLong(1, customerId);
			prepStat.setLong(2, accNo);
			try (ResultSet rSet = prepStat.executeQuery();){
				map = transactionPrintRset(rSet);
			}
		} catch (SQLException e) {
			throw new CustomException("Error occured while execution of prepared statement." , e);
		}
		return map;
	}

	public Map<Long,Map<Long,TransactionDetailsPojo>> transactionPrintRset(ResultSet rSet) throws CustomException {
		
		Map<Long,Map<Long,TransactionDetailsPojo>>  map = new LinkedHashMap<>();
		Map<Long,TransactionDetailsPojo> innerMap = new LinkedHashMap<>();

		try {
			while(rSet.next()) {
				TransactionDetailsPojo obj = new TransactionDetailsPojo();
				obj.setUserId(rSet.getLong(1));
				obj.setAccountNo(rSet.getLong(2));
				obj.setTransferId(rSet.getLong(3));
				obj.setTime(rSet.getLong(4));
				obj.setMode(rSet.getString(5));
				obj.setType(rSet.getString(6));
				obj.setAmount(rSet.getDouble(7));
				obj.setReceivedFrom(rSet.getLong(8));
				obj.setSendTo(rSet.getLong(9));
				obj.setBalance(rSet.getDouble(10));
				innerMap.put(rSet.getLong(3), obj);
				map.put(rSet.getLong(2), innerMap);
			}

		} catch (SQLException e) {
			throw new CustomException("Error occured." , e);
		}
		return map;
	}

	public void printTransactionInfo(Map<Long,Map<Long,TransactionDetailsPojo>> input, long accNo) throws CustomException {

		MyUtil.checkNull(input);

		Map<Long,TransactionDetailsPojo> innerMap = input.get(accNo);
		for(Map.Entry<Long,TransactionDetailsPojo> entry : innerMap.entrySet()) {
			TransactionDetailsPojo obj = entry.getValue();
			System.out.println("_______________________________________________________________________________________________________________\n");
			System.out.println("CUSTOMER_ID\t- " + obj.getUserId());
			System.out.println("ACCOUNT_NO\t- " + obj.getAccountNo());
			System.out.println("TRANSFER_ID\t- " + obj.getTransferId());
			System.out.println("TIME\t\t- " + obj.getTime());
			System.out.println("MODE\t\t- " + obj.getMode());
			System.out.println("TYPE\t\t- " + obj.getType());
			System.out.println("AMOUNT\t\t- " + obj.getAmount());
			System.out.println("RECEIVED FROM\t- " + obj.getReceivedFrom());
			System.out.println("SEND TO\t\t- " + obj.getSendTo());
			System.out.println("BALANCE\t\t- " + obj.getBalance());
		}
		System.out.println("_______________________________________________________________________________________________________________\n");
	}

	// deposit
	@Override
	public void deposit(long userId, long accNo, double amount) throws CustomException {

		AccountDetailsPojo oldBalance = getBalance(accNo);
		double newBalance = oldBalance.getBalance() + amount;
		String query = "UPDATE ACCOUNT_DETAILS SET BALANCE = ? WHERE ACCOUNT_NO = ?";
		String reference = "INSERT INTO TRANSACTION_REFERENCE (MODE) VALUES ('DEPOSIT')";
		String lastIndex = "SELECT REFERENCE_ID FROM TRANSACTION_REFERENCE ORDER BY REFERENCE_ID DESC LIMIT 1";
		int referenceId = 0;
		
		try (PreparedStatement prepStat = getConnection().prepareStatement(query);
				PreparedStatement prepStat3 = getConnection().prepareStatement(reference);
				PreparedStatement prepStat4 = getConnection().prepareStatement(lastIndex);) {
			prepStat.setDouble(1, newBalance);
			prepStat.setLong(2, accNo);
			prepStat.addBatch();
			prepStat.execute();
			prepStat3.execute();
			try (ResultSet rSet = prepStat4.executeQuery()){
				while(rSet.next()) {
					referenceId = rSet.getInt(1);
				}
			}
		} catch (SQLException e) {
			throw new CustomException("Error occured while execution of prepared statement." , e);
		}
		updateTransaction(setDepositTransaction(userId, accNo, referenceId, amount, newBalance));
	}
	
	public TransactionDetailsPojo setDepositTransaction(long userId, long accNo, int reference, double amount, double balance) {
		
		TransactionDetailsPojo obj = new TransactionDetailsPojo();
		long time = getTime();
		obj.setUserId(userId);
		obj.setAccountNo(accNo);
		obj.setReferenceId(reference);
		obj.setTime(time);
		obj.setMode("DEPOSIT");
		obj.setType("CREDIT");
		obj.setAmount(amount);
		obj.setBalance(balance);
		return obj;
	}

//	public void requestWithdraw(long customerId, long accNo) {
//		
//		String query = "INSERT INTO REQUEST_DETAILS VALUES (?,?,?,?)";
//		
//		
//		
//	}
	
	@Override
	// withdraw
	public void withdraw(long userId, long accNo, double amount) throws CustomException  {

		AccountDetailsPojo oldBalance = getBalance(accNo);
		double newBalance = oldBalance.getBalance() - amount;
		
		MyUtil.validWithdraw(oldBalance.getBalance(), amount);
		
		String query = "UPDATE ACCOUNT_DETAILS SET BALANCE = ? WHERE ACCOUNT_NO = ?";
		String reference = "INSERT INTO TRANSACTION_REFERENCE (MODE) VALUES ('WITHDRAW')";
		String lastIndex = "SELECT REFERENCE_ID FROM TRANSACTION_REFERENCE ORDER BY REFERENCE_ID DESC LIMIT 1";
		int referenceId = 0;
		try (PreparedStatement prepStat = getConnection().prepareStatement(query);
				PreparedStatement prepStat3 = getConnection().prepareStatement(reference);
				PreparedStatement prepStat4 = getConnection().prepareStatement(lastIndex);){
			prepStat.setDouble(1, newBalance);
			prepStat.setLong(2, accNo);
			prepStat.addBatch();
			prepStat.execute();
			prepStat3.execute();
			try (ResultSet rSet = prepStat4.executeQuery()){
				while(rSet.next()) {
					referenceId = rSet.getInt(1);
				}
			}
		} catch (SQLException e) {
			throw new CustomException("Error occured while execution of prepared statement." , e);
		}
		updateTransaction(setWithdrawTransaction(userId, accNo, referenceId, amount, newBalance));
	}
	
	public TransactionDetailsPojo setWithdrawTransaction(long userId, long accNo, int reference, double amount, double balance) {
		
		TransactionDetailsPojo obj = new TransactionDetailsPojo();
		long time = getTime();
		obj.setUserId(userId);
		obj.setAccountNo(accNo);
		obj.setReferenceId(reference);
		obj.setTime(time);
		obj.setMode("WITHDRAW");
		obj.setType("DEBIT");
		obj.setAmount(amount);
		obj.setBalance(balance);
		return obj;
	}

	@Override
	public void transfer(long senderId, long senderAcc, long receiverAcc, double amount) throws CustomException {

		AccountDetailsPojo senderObj = getBalance(senderAcc);
		AccountDetailsPojo receiverObj = getBalance(receiverAcc);
		double senderBalance = senderObj.getBalance() - amount;
		double receiverBalance = receiverObj.getBalance() + amount;
		
		MyUtil.validTransfer(senderObj.getBalance(), amount);

		AccountDetailsPojo receiver = getId(receiverAcc);
		String debitQuery = "UPDATE ACCOUNT_DETAILS SET BALANCE = ? WHERE ACCOUNT_NO = ?";
		String creditQuery = "UPDATE ACCOUNT_DETAILS SET BALANCE = ? WHERE ACCOUNT_NO = ?";
		String reference = "INSERT INTO TRANSACTION_REFERENCE (MODE) VALUES ('TRANSFER')";
		String lastIndex = "SELECT REFERENCE_ID FROM TRANSACTION_REFERENCE ORDER BY REFERENCE_ID DESC LIMIT 1";
		int referenceId = 0;
		
		try (PreparedStatement prepStat1 = getConnection().prepareStatement(debitQuery);
				PreparedStatement prepStat2 = getConnection().prepareStatement(creditQuery);
				PreparedStatement prepStat3 = getConnection().prepareStatement(reference);
				PreparedStatement prepStat4 = getConnection().prepareStatement(lastIndex);){
			prepStat1.setDouble(1, senderBalance);
			prepStat1.setLong(2, senderAcc);
			prepStat1.addBatch();
			prepStat1.execute();
			prepStat2.setDouble(1, receiverBalance);
			prepStat2.setLong(2, receiverAcc);
			prepStat2.addBatch();
			prepStat2.execute();
			prepStat3.execute();
			try (ResultSet rSet = prepStat4.executeQuery()){
				while(rSet.next()) {
					referenceId = rSet.getInt(1);
				}
			}
		} catch (SQLException e) {
			throw new CustomException("Error occured while execution of prepared statement." , e);
		}
		updateTransaction(setSenderTransaction(senderId, senderAcc, receiverAcc, referenceId, amount, senderBalance));
		updateTransaction(setReceiverTransaction(receiver.getCustomerId(), senderAcc, receiverAcc, referenceId, amount, receiverBalance));
	}

	public TransactionDetailsPojo setSenderTransaction(long userId, long SenderAccNo, long ReceiverAccNo, int reference, double amount, double balance) {
		
		TransactionDetailsPojo obj = new TransactionDetailsPojo();
		long time = getTime();
		obj.setUserId(userId);
		obj.setAccountNo(SenderAccNo);
		obj.setReferenceId(reference);
		obj.setTime(time);
		obj.setMode("TRANSFER");
		obj.setType("DEBIT");
		obj.setAmount(amount);
		obj.setSendTo(ReceiverAccNo);
		obj.setBalance(balance);
		return obj;
	}
	
	public TransactionDetailsPojo setReceiverTransaction(long userId, long SenderAccNo, long ReceiverAccNo, int reference, double amount, double balance) {
		
		TransactionDetailsPojo obj = new TransactionDetailsPojo();
		long time = getTime();
		obj.setUserId(userId);
		obj.setAccountNo(ReceiverAccNo);
		obj.setReferenceId(reference);
		obj.setTime(time);
		obj.setMode("TRANSFER");
		obj.setType("CREDIT");
		obj.setAmount(amount);
		obj.setReceivedFrom(SenderAccNo);
		obj.setBalance(balance);
		return obj;
	}
	
	@Override
	public void updateTransaction(TransactionDetailsPojo obj) throws CustomException {
		
		String query = "INSERT INTO TRANSACTION_DETAILS (CUSTOMER_ID,ACCOUNT_NO,REFERENCE_ID,TIME,MODE_OF_TRANSACTION,TYPE,AMOUNT,RECEIVED_FROM,SEND_TO,CLOSING_BALANCE) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try (PreparedStatement prepStat3 = getConnection().prepareStatement(query);){
			
			prepStat3.setLong(1, obj.getUserId());
			prepStat3.setLong(2, obj.getAccountNo());
			prepStat3.setInt(3, obj.getReferenceId());
			prepStat3.setLong(4, obj.getTime());
			prepStat3.setString(5, obj.getMode());
			prepStat3.setString(6, obj.getType());
			prepStat3.setDouble(7, obj.getAmount());
			prepStat3.setLong(8, obj.getReceivedFrom());
			prepStat3.setLong(9, obj.getSendTo());
			prepStat3.setDouble(10, obj.getBalance());
			prepStat3.addBatch();
			prepStat3.execute();
		} catch (SQLException e) {
			throw new CustomException("Error occured while execution of prepared statement." , e);
		}
	}

	@Override
	public AccountDetailsPojo getId(long accNo) throws CustomException {
		
		String query = "SELECT CUSTOMER_ID FROM ACCOUNT_DETAILS WHERE ACCOUNT_NO = ?";
		AccountDetailsPojo obj = new AccountDetailsPojo();
		try (PreparedStatement prepStat = getConnection().prepareStatement(query);) {
			prepStat.setLong(1, accNo);
			try(ResultSet rSet = prepStat.executeQuery()){
				while(rSet.next()) {
					obj.setCustomerId(rSet.getLong(1));
				}
			}

		} catch (SQLException e) {
			throw new CustomException("Error occured while execution of prepared statement." , e);
		}
		return obj;
	}

	// balance
	@Override
	public AccountDetailsPojo getBalance(long accNo) throws CustomException {

		String query = "SELECT BALANCE FROM ACCOUNT_DETAILS WHERE ACCOUNT_NO = ?";
		AccountDetailsPojo obj = new AccountDetailsPojo();
		try (PreparedStatement prepStat = getConnection().prepareStatement(query);){
			prepStat.setLong(1, accNo);
			try (ResultSet rSet = prepStat.executeQuery();){
				while(rSet.next()) {
					obj.setBalance(rSet.getDouble(1));
				}
			}
		} catch (SQLException e) {
			throw new CustomException("Error occured while execution of prepared statement." , e);
		}
		return obj;
	}

	// current time
	public long getTime() {
		long milli = System.currentTimeMillis();
		return milli;
	}
	
	// print accounts
	public List<Long> printAccounts(Map<Long, Map<Long, AccountDetailsPojo>> input, Long userId) throws CustomException {

		MyUtil.checkNull(input);

		Map<Long, AccountDetailsPojo> innerMap = input.get(userId);
		List<Long> accountList = new ArrayList<>();
		for(Entry<Long, AccountDetailsPojo> entry : innerMap.entrySet()) {
			AccountDetailsPojo obj = entry.getValue();
			accountList.add(obj.getAccountNo());
		}
		return accountList;
	}
}
