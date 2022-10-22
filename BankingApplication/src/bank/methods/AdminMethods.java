package bank.methods;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import bank.pojo.AccountDetailsPojo;
import bank.pojo.CustomerDetailsPojo;
import bank.pojo.TransactionDetailsPojo;
import bank.pojo.UserDetailsPojo;
import bank.storagelayer.AdminStorageInterface;
import myutil.CustomException;
import myutil.MyUtil;

public class AdminMethods implements AdminStorageInterface{

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
	
	@Override
	public Map<Long,UserDetailsPojo> showUser(Long... userId) throws CustomException {
		
		Map<Long,UserDetailsPojo> map = new LinkedHashMap<>();
		int len = userId.length;
		
		if(len == 0) {
			String query = "SELECT * FROM USER_DETAILS";
			try(PreparedStatement prepStat = getConnection().prepareStatement(query)){
				try (ResultSet rSet = prepStat.executeQuery();){
					map = setUserDetails(rSet,map);
				}
			} catch (SQLException e) {
				throw new CustomException("Error occured while establishing connection.", e);
			}
		} else {
		String query = "SELECT * FROM USER_DETAILS WHERE USER_ID = ?";
		try(PreparedStatement prepStat = getConnection().prepareStatement(query)){
			for(Long id : userId) {
				prepStat.setLong(1, id);
				try (ResultSet rSet = prepStat.executeQuery();){
					map = setUserDetails(rSet,map);
				}
			}
		} catch (SQLException e) {
			throw new CustomException("Error occured while establishing connection.", e);
		}
		}
		return map;
	}
	
	public Map<Long,UserDetailsPojo> setUserDetails(ResultSet rSet, Map<Long,UserDetailsPojo> inputMap) throws CustomException {
		
		try {
			while(rSet.next()) {
				UserDetailsPojo obj = new UserDetailsPojo();
				obj.setUserId(rSet.getLong("USER_ID"));
				obj.setUserName(rSet.getString("NAME"));
				obj.setDOB(rSet.getString("DOB"));
				obj.setMobileNum(rSet.getString("MOBILE"));
				obj.setRole(rSet.getString("ROLE"));
				obj.setPassword(rSet.getString("PASSWORD"));
				inputMap.put(obj.getUserId(), obj);
			}
		} catch (SQLException e) {
			throw new CustomException("Error occured." , e);
		}
		return inputMap;
	}
	
	public void printUserInfo(Map<Long,UserDetailsPojo> input) {
		
		Iterator<UserDetailsPojo> itr = input.values().iterator();
		while(itr.hasNext()) {
			UserDetailsPojo obj = itr.next();
			System.out.println("_______________________________________________________________________________________________________________\n");
			System.out.println("USER_ID\t- " + obj.getUserId());
			System.out.println("NAME\t- " + obj.getUserName());
			System.out.println("DOB\t- " + obj.getDOB());
			System.out.println("MOBILE\t- " + obj.getMobileNum());
			System.out.println("ROLE\t- " + obj.getRole());
			System.out.println("PASSWORD- " + obj.getPassword());
			System.out.println("_______________________________________________________________________________________________________________");
		}
	}

	@Override
	public Map<Long, Map<Long, AccountDetailsPojo>> showAccounts(Long... customerId) throws CustomException {

		Map<Long, Map<Long, AccountDetailsPojo>> map = new LinkedHashMap<>();
		int len = customerId.length;
		if(len == 0) {
			String query = "SELECT * FROM ACCOUNT_DETAILS";

			try(PreparedStatement prepStat = getConnection().prepareStatement(query)){
				try (ResultSet rSet = prepStat.executeQuery();){
					map = setAccountDetails(rSet, map);
				}
			} catch (SQLException e) {
				throw new CustomException("Error occured while establishing connection.", e);
			}
		} else {
			String query = "SELECT * FROM ACCOUNT_DETAILS WHERE CUSTOMER_ID = ?";
			try(PreparedStatement prepStat = getConnection().prepareStatement(query)){
				for(Long id : customerId) {
					prepStat.setLong(1, id);
					try (ResultSet rSet = prepStat.executeQuery();){
						map = setAccountDetails(rSet, map);
					}
				}
			} catch (SQLException e) {
				throw new CustomException("Error occured while establishing connection.", e);
			}
		}
		return map;
	}
	
	public Map<Long, Map<Long, AccountDetailsPojo>> setAccountDetails(ResultSet rSet, Map<Long, Map<Long, AccountDetailsPojo>> inputMap) throws CustomException {

		Map<Long, AccountDetailsPojo> innerMap = new LinkedHashMap<>();
		
		try {
			while(rSet.next()) {
				AccountDetailsPojo obj = new AccountDetailsPojo();
				obj.setCustomerId(rSet.getLong("CUSTOMER_ID"));
				obj.setAccountNo(rSet.getLong("ACCOUNT_NO"));
				obj.setAccountType(rSet.getString("ACCOUNT_TYPE"));
				obj.setBranch(rSet.getString("BRANCH"));
				obj.setBalance(rSet.getDouble("BALANCE"));
				obj.setStatus(rSet.getString("STATUS"));
				innerMap.put(obj.getAccountNo(), obj);
				inputMap.put(obj.getCustomerId(), innerMap);
			}
		} catch (SQLException e) {
			throw new CustomException("Error occured." , e);
		}
		return inputMap;
	}
	
	public void printAccountInfo(Map<Long,Map<Long,AccountDetailsPojo>> input) throws CustomException {

		MyUtil.checkNull(input);

		Iterator<Map<Long, AccountDetailsPojo>> itr = input.values().iterator();
		Map<Long, AccountDetailsPojo> innerMap = itr.next();
		Collection<AccountDetailsPojo> collection = innerMap.values();
		
		for(AccountDetailsPojo obj : collection) {
			System.out.println("_______________________________________________________________________________________________________________\n");
			System.out.println("CUSTOMER_ID\t- " + obj.getCustomerId());
			System.out.println("ACCOUNT_NO\t- " + obj.getAccountNo());
			System.out.println("ACCOUNT_TYPE\t- " + obj.getAccountType());
			System.out.println("BRANCH\t\t- " + obj.getBranch());
			System.out.println("BALANCE\t\t- " + obj.getBalance());
			System.out.println("ACCOUNT STATUS\t- " + obj.getStatus());
		}
		System.out.println("_______________________________________________________________________________________________________________");
	}

	@Override
	public void createCustomer(CustomerDetailsPojo customer) throws CustomException {
		
		String userQuery = "INSERT INTO USER_DETAILS (NAME, DOB, MOBILE, ROLE, PASSWORD) VALUES (?,?,?,?,?)";
		String customerQuery = "INSERT INTO CUSTOMER_DETAILS (CUSTOMER_ID,AADHAAR_NUMBER,PAN_NUMBER,STATUS) VALUES (?,?,?,?)";
		
		try (PreparedStatement prepStat1 = getConnection().prepareStatement(userQuery,Statement.RETURN_GENERATED_KEYS);
			PreparedStatement prepStat2 = getConnection().prepareStatement(customerQuery);){
			prepStat1.setString(1, customer.getUserName());
			prepStat1.setString(2, customer.getDOB());
			prepStat1.setString(3, customer.getMobileNum());
			prepStat1.setString(4, customer.getRole());
			prepStat1.setString(5, customer.getPassword());
			prepStat1.addBatch();
			prepStat1.execute();
			try(ResultSet rSet = prepStat1.getGeneratedKeys()){
				while(rSet.next()) {
					prepStat2.setLong(1, rSet.getLong(1));
				}
			}
			prepStat2.setLong(2, customer.getAadharNum());
			prepStat2.setString(3, customer.getPanNum());
			prepStat2.setString(4, customer.getStatus());
			prepStat2.addBatch();
			prepStat2.execute();
		} catch (SQLException e) {
			throw new CustomException("Error occured while execution of prepared statement." , e);
		}
	}

	@Override
	public void createAccount(AccountDetailsPojo account) throws CustomException {

		String userQuery = "INSERT INTO ACCOUNT_DETAILS (CUSTOMER_ID, ACCOUNT_TYPE, BRANCH, BALANCE, STATUS) VALUES (?,?,?,?,?)";
		
		try (PreparedStatement prepStat1 = getConnection().prepareStatement(userQuery);){
				prepStat1.setLong(1, account.getCustomerId());
				prepStat1.setString(2, account.getAccountType());
				prepStat1.setString(3, account.getBranch());
				prepStat1.setDouble(4, account.getBalance());
				prepStat1.setString(5, account.getStatus());
				prepStat1.addBatch();
				prepStat1.execute();
		} catch (SQLException e) {
			throw new CustomException("Error occured while execution of prepared statement." , e);
		}
	}

	@Override
	public Map<Long, Map<Long, TransactionDetailsPojo>> getTransactionDetails(long customerId, Long... accounts) throws CustomException {

		Map<Long,Map<Long,TransactionDetailsPojo>> map = new LinkedHashMap<>();
		int len = accounts.length;

		if(len == 0) {
			String query = "SELECT * FROM TRANSACTION_DETAILS WHERE CUSTOMER_ID = ? ORDER BY TIME DESC limit 10";
			try (PreparedStatement prepStat = getConnection().prepareStatement(query);){
				prepStat.setLong(1, customerId);
				try (ResultSet rSet = prepStat.executeQuery();){
					map = transactionPrintRset(rSet, map);
				}
			}catch (SQLException e) {
				throw new CustomException("Error occured while execution of prepared statement." , e);
			}
		} else {
			String query = "SELECT * FROM TRANSACTION_DETAILS WHERE CUSTOMER_ID = ? AND ACCOUNT_NO = ? ORDER BY TIME DESC limit 5";

			try (PreparedStatement prepStat = getConnection().prepareStatement(query);){
				prepStat.setLong(1, customerId);
				for(Long accNo : accounts) {
					prepStat.setLong(2, accNo);
					try (ResultSet rSet = prepStat.executeQuery();){
						map = transactionPrintRset(rSet, map);
					}
				}
			} catch (SQLException e) {
				throw new CustomException("Error occured while execution of prepared statement." , e);
			}
		}
		return map;
	}
	
	public Map<Long,Map<Long,TransactionDetailsPojo>> transactionPrintRset(ResultSet rSet,Map<Long, Map<Long,TransactionDetailsPojo>> input) throws CustomException {

		Map<Long,TransactionDetailsPojo> innerMap = new LinkedHashMap<>();

		try {
			while(rSet.next()) {
				TransactionDetailsPojo obj = new TransactionDetailsPojo();
				obj.setUserId(rSet.getLong("CUSTOMER_ID"));
				obj.setAccountNo(rSet.getLong("ACCOUNT_NO"));
				obj.setTransferId(rSet.getLong("REFERENCE_ID"));
				obj.setReferenceId(rSet.getInt("TRANSACTION_ID"));
				obj.setTime(rSet.getLong("TIME"));
				obj.setMode(rSet.getString("MODE_OF_TRANSACTION"));
				obj.setType(rSet.getString("TYPE"));
				obj.setAmount(rSet.getDouble("AMOUNT"));
				obj.setReceivedFrom(rSet.getLong("RECEIVED_FROM"));
				obj.setSendTo(rSet.getLong("SEND_TO"));
				obj.setBalance(rSet.getDouble("CLOSING_BALANCE"));
				innerMap.put(rSet.getLong("REFERENCE_ID"), obj);
				input.put(rSet.getLong("ACCOUNT_NO"), innerMap);
			}

		} catch (SQLException e) {
			throw new CustomException("Error occured." , e);
		}
		return input;
	}

	public void printTransactionInfo(Map<Long,Map<Long,TransactionDetailsPojo>> input) throws CustomException {
		
		MyUtil.checkNull(input);
		
		Iterator<Map<Long, TransactionDetailsPojo>> itr = input.values().iterator();
		Map<Long, TransactionDetailsPojo> innerMap = itr.next();
		Collection<TransactionDetailsPojo> collection = innerMap.values();
		
		for(TransactionDetailsPojo obj : collection) {
			System.out.println("_______________________________________________________________________________________________________________\n");
			System.out.println("CUSTOMER_ID\t- " + obj.getUserId());
			System.out.println("ACCOUNT_NO\t- " + obj.getAccountNo());
			System.out.println("REFERENCE_ID\t- " + obj.getReferenceId());
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
	
}
