package beginner.methods.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import myutil.CustomException;
import myutil.MyUtil;

public class JdbcMethods {

	
	public Connection getConnection() throws CustomException {
		String url = "jdbc:mysql://localhost/incubationDB";
		String user = "root";
		String password = "Root@123";
		 
		try {
			Connection connection = DriverManager.getConnection(url, user, password);
			return connection;
		} catch(SQLException e) {
			throw new CustomException("Error occured while establishing connection.", e);//swami
		}
		
	}
	
	// experiment 1
	public void createTable(String tableName) throws CustomException {
		
		MyUtil.checkNull(tableName);
		
		String query = "CREATE TABLE " + tableName
				+"(EMPLOYEE_ID 		int unsigned NOT NULL,"
				+ "NAME 			VARCHAR(250),"
				+ "MOBILE 			VARCHAR(100),"
				+ "EMAIL 			VARCHAR(150),"
				+ "DEPARTMENT 		VARCHAR(250),"
				+ "PRIMARY KEY		(EMPLOYEE_ID))";
		
		try (PreparedStatement prepStat = getConnection().prepareStatement(query);){
			
			prepStat.execute();
			
		} catch (SQLException e) {
			throw new CustomException("Error occured while execution of prepared statement." + e);
		}
	}
	
	// experiment 2
	public void insertData(String table, List<List<String>> input, int count) throws CustomException {
		
		MyUtil.checkNull(table); MyUtil.checkNull(input); 
		
		String query = "INSERT INTO " + table + " VALUES (?, ?, ?, ?, ?);";
		
		try (PreparedStatement prepStat = getConnection().prepareStatement(query);){
			
//			for(int i = 0; i<count; i++) {
//				prepStat.setInt(1, id);
//				prepStat.setString(2, name);
//				prepStat.setString(3, mob);
//				prepStat.setString(4, email);
//				prepStat.setString(5, department);
//				prepStat.addBatch();
//			}
			
			for(List<?> list : input) {
				int len = list.size();
				for(int i = 1; i<=len; i++) {
					prepStat.setString(i, list.get(i-1).toString());
				}
				prepStat.addBatch();
			}
			prepStat.execute();
		} catch (SQLException e) {
			throw new CustomException("Error occured while execution of prepared statement." + e);
		}
	}
	
	// experiment 3
	public List<Map<String,String>> selectData(String table, String name, int id) throws CustomException {
		
		MyUtil.checkNull(table); MyUtil.checkNull(name);
		
		String query = "SELECT * FROM " + table + " WHERE NAME = ? AND EMPLOYEE_ID = ?";
		List<Map<String,String>> input = createArrayList();
		
		try (PreparedStatement prepStat = getConnection().prepareStatement(query);){
			
			prepStat.setString(1, name);
			prepStat.setInt(2, id);
			prepStat.addBatch();
			try (ResultSet rSet = prepStat.executeQuery();){
				
				input = printRSet(rSet);
				
			}
		} catch (SQLException e) {
			throw new CustomException("Error occured while execution of prepared statement." + e);
		}
		return input;
	}
	
	public List<Map<String,String>> printRSet(ResultSet rSet) throws CustomException {
		
		MyUtil.checkNull(rSet);
		
		List<Map<String,String>> list = createArrayList();
		try {
		ResultSetMetaData rsmd = rSet.getMetaData();
		int columnCount = rsmd.getColumnCount();
		while(rSet.next()) {
			Map<String,String> map = createLinkedMap();
			for(int i = 1; i < columnCount; i++) {
					map.put(rsmd.getColumnName(i),rSet.getString(i));
			}
			list.add(map);
		}
		} catch (SQLException e) {
				throw new CustomException("Error occured." , e);
		}
//		while(rSet.next()){
//			Map<String,String> map = createLinkedMap();
//			String id = rSet.getString("EMPLOYEE_ID");
//			map.put("EMPLOYEE_ID", id);
//			String name = rSet.getString("NAME");
//			map.put("NAME", name);
//			String mob = rSet.getString("MOBILE");
//			map.put("MOBILE", mob);
//			String email = rSet.getString("EMAIL");
//			map.put("EMAIL", email);
//			String dep = rSet.getString("DEPARTMENT");
//			map.put("DEPARTMENT", dep);
//			list.add(map);
//		}
		return list;
	}
	
	public <T> List<T> createArrayList() {
		List<T> list = new ArrayList<>();
		return list;
	}
	
	// experiment 4
	public void updateData(String table, String column, String alter, int id) throws CustomException {
		
		MyUtil.checkNull(table); MyUtil.checkNull(column); MyUtil.checkNull(alter);
		
		String query = "UPDATE "+table+" SET "+column+" = ? WHERE EMPLOYEE_ID = ?";
		
		try (PreparedStatement prepStat = getConnection().prepareStatement(query);){
				
			prepStat.setString(1, alter);
			prepStat.setInt(2, id);
			prepStat.addBatch();//swami
			prepStat.execute();
		} catch (SQLException e) {
			throw new CustomException("Error occured while execution of prepared statement." + e);
		}
	}
	
	// experiment 5
	public List<Map<String,String>> fetchRows(String table,  int limit) throws CustomException {
		
		MyUtil.checkNull(table);
		
		String query = "SELECT * FROM " + table + " ORDER BY EMPLOYEE_ID LIMIT " + limit ;
		List<Map<String,String>> input = createArrayList();

		try (PreparedStatement prepStat = getConnection().prepareStatement(query);){
			
			try (ResultSet rSet = prepStat.executeQuery(query);){
				
				input = printRSet(rSet);
			}
		}catch (SQLException e) {
			throw new CustomException("Error occured." , e);
		}
		return input;
	}
	
	// experiment 6
	public List<Map<String,String>> descendData(String table, int limit) throws CustomException{
		
		MyUtil.checkNull(table);
		
		String query = "SELECT * FROM " + table + " ORDER BY NAME DESC LIMIT " + limit ;
		List<Map<String,String>> input = createArrayList();
		
		try (PreparedStatement prepStat = getConnection().prepareStatement(query);){
			
			ResultSet rSet = prepStat.executeQuery(query);
			input = printRSet(rSet);
			
		}catch (SQLException e) {
			throw new CustomException("Error occured." , e);
		}
		return input;
	}
	
	// experiment 7
	public void deleteData(String table, String id) throws CustomException{
		
		MyUtil.checkNull(table); MyUtil.checkNull(id);
		
		String query = "DELETE FROM " + table + " WHERE EMPLOYEE_ID = ?";
		
		try (PreparedStatement prepStat = getConnection().prepareStatement(query);){
				
			prepStat.setString(1, id);
			prepStat.execute();
				
		}catch (SQLException e) {
			throw new CustomException("Error occured." , e);
		}
	}
	
	// experiment 8
	// experiment 2 modified
	public void insertPojoData(String table, List<EmployeePojo> inputList) throws CustomException {
		
		MyUtil.checkNull(table);
		
		String query = "INSERT INTO " + table + " VALUES (?, ?, ?, ?, ?)";
		
		try (PreparedStatement prepStat = getConnection().prepareStatement(query);){
				
			for(EmployeePojo obj : inputList) {
				prepStat.setString(1, obj.getId());
				prepStat.setString(2, obj.getEmpName());
				prepStat.setString(3, obj.getMobile());
				prepStat.setString(4, obj.getEmail());
				prepStat.setString(5, obj.getDepartment());
				prepStat.addBatch();
			}
			prepStat.execute();
		}catch (SQLException e) {
			throw new CustomException("Error occured while execution of prepared statement." + e);
		}
	}
	
	// experiment 3 modified 
	public Map<Integer,Map<String, String>> selectPojoData(String table, String name, int id) throws CustomException {
		
		MyUtil.checkNull(table); MyUtil.checkNull(name);
		
		String query = "SELECT * FROM " + table + " WHERE NAME = ? AND EMPLOYEE_ID = ?";
		Map<Integer,Map<String, String>> input = createLinkedMap();
		
		try (PreparedStatement prepStat = getConnection().prepareStatement(query);){
				
			prepStat.setString(1, name);
			prepStat.setInt(2, id);
			prepStat.addBatch();
			ResultSet rSet = prepStat.executeQuery();
			input = printPojoRSet(rSet);
			
		} catch (SQLException e) {
			throw new CustomException("Error occured." , e);
		}
		return input;
	}
	
	public <K, V> Map<K, V> createLinkedMap(){
		Map <K, V> map = new LinkedHashMap<>();
		return map;
	}
	
	public Map<Integer,Map<String, String>> printPojoRSet(ResultSet rSet) throws CustomException{
		
		MyUtil.checkNull(rSet);
		
		Map<Integer,Map<String, String>> map = createLinkedMap();
		Integer key = 1;
		ResultSetMetaData rsmd;
		try {
			rsmd = rSet.getMetaData();
		int columnCount = rsmd.getColumnCount();
		while(rSet.next()) {
			Map<String,String> map1 = createLinkedMap();
			for(int i = 1; i < columnCount; i++) {
				map1.put(rsmd.getColumnName(i),rSet.getString(i));
			}
			map.put(key, map1);
			key++;
		}
		} catch (SQLException e) {
			throw new CustomException("Error occured." , e);
		}
//		while(rSet.next()) {
//			Map<String, String> map1 = createLinkedMap();
//			String id = rSet.getString("EMPLOYEE_ID");
//			map1.put("EMPLOYEE_ID", id);
//			String name = rSet.getString("NAME");
//			map1.put("NAME", name);
//			String mob = rSet.getString("MOBILE");
//			map1.put("MOBILE", mob);
//			String email = rSet.getString("EMAIL");
//			map1.put("EMAIL", email);
//			String dep = rSet.getString("DEPARTMENT");
//			map1.put("DEPARTMENT", dep);
//			map.put(key, map1);
//			key++;
//		}
		return map;
	}
	
	// experiment 5 modified
	public Map<Integer, Map<String, String>> fetchRowsPojo(String table, int limit) throws CustomException {
		
		MyUtil.checkNull(table);
		
		String query = "SELECT * FROM "+table+" ORDER BY EMPLOYEE_ID LIMIT "+limit;
		Map<Integer,Map<String, String>> input = createLinkedMap();
		
		try (PreparedStatement prepStat = getConnection().prepareStatement(query);){
				
			input = printPojoRSet(prepStat.executeQuery(query));
			
		} catch (SQLException e) {
			throw new CustomException("Error occured." , e);
		}
		return input;
	}
	
	// experiment 6 modified
	public Map<Integer, Map<String, String>> descendDataPojo(String table, int limit) throws CustomException {
		
		MyUtil.checkNull(table);
		
		String query = "SELECT * FROM "+table+" ORDER BY EMPLOYEE_ID DESC LIMIT "+ limit;
		Map<Integer,Map<String,String>> input = createLinkedMap();
		
		try (PreparedStatement prepStat = getConnection().prepareStatement(query);){
				
			try (ResultSet rSet = prepStat.executeQuery()){
					
				input = printPojoRSet(rSet);
				
			}
			
		} catch (SQLException e) {
			throw new CustomException("Error occured." , e);
		}
		return input;
	}
	
	public void printMap(Map<Integer, Map<String, String>> input) {
		
		input.forEach((k, v) -> System.out.println("Key "+ k + v + "\n"));
	}
	
	// experiment 9
	public void createDependent(String table, String parentTable, String foreignKey) throws CustomException {
		
		MyUtil.checkNull(table); MyUtil.checkNull(parentTable); MyUtil.checkNull(foreignKey);
		
		String query = "CREATE TABLE " + table + "("
				+ "ID			INT UNSIGNED,"
				+ "NAME			VARCHAR(250),"
				+ "AGE			INT UNSIGNED,"
				+ "RELATIONSHIP	VARCHAR(100),"
				+ "GENDER		VARCHAR(100),"
				+ "FOREIGN KEY	(ID) REFERENCES "
				+ parentTable +"("+foreignKey+")"
				+");";
		
		try (PreparedStatement prepStat = getConnection().prepareStatement(query);) {
				
			prepStat.executeQuery();
		} catch (SQLException e) {
			throw new CustomException("Error occured." , e);
		}
	}
	
	// experiment 10
	public void insertDependentData(String table, List<DependentPojo> inputList) throws CustomException {
		
		MyUtil.checkNull(table); MyUtil.checkNull(inputList);
		
		String query = "INSERT INTO " + table + " VALUES (?, ?, ?, ?, ?)";
		
		try (PreparedStatement prepStat = getConnection().prepareStatement(query);){
				
			for(DependentPojo obj : inputList) {
				prepStat.setString(1, obj.getID());
				prepStat.setString(2, obj.getPersonName());
				prepStat.setString(3, obj.getAge());
				prepStat.setString(4, obj.getRelationship());
				prepStat.setString(5, obj.getGender());
				prepStat.addBatch();
				prepStat.execute();
			}
			
		} catch (SQLException e) {
			throw new CustomException("Error occured." , e);
		}
	}
	
	// experiment 11
	public List<Map<String,String>> fetchMatching(int id) throws CustomException {
		
		String query = "SELECT EMPLOYER_POJO.EMPLOYEE_ID,EMPLOYER_POJO.NAME,DEPENDENT.* from EMPLOYER_POJO "
				+ "left join DEPENDENT on EMPLOYER_POJO.EMPLOYEE_ID = DEPENDENT.ID "
				+ "WHERE EMPLOYER_POJO.EMPLOYEE_ID = ?";
		List<Map<String,String>> input = createArrayList();
		
		try (PreparedStatement prepStat = getConnection().prepareStatement(query);){
				
			prepStat.setInt(1, id);
			try (ResultSet rSet = prepStat.executeQuery();){
					
				input = printMatchSet(rSet);
				
			}
		} catch (SQLException e) {
			throw new CustomException("Error occured." , e);
		}
		return input;
	}
	
	public List<Map<String,String>> printMatchSet(ResultSet rSet) throws CustomException {
		
		MyUtil.checkNull(rSet);
		
		List<Map<String,String>> list = createArrayList();
		ResultSetMetaData rsmd;
		try {
			rsmd = rSet.getMetaData();
		int columnCount = rsmd.getColumnCount();
		while(rSet.next()) {
			Map<String,String> map = createLinkedMap();
			for(int i = 1; i < columnCount; i++) {
				map.put(rsmd.getColumnName(i),rSet.getString(i));
			}
			list.add(map);
		}
		} catch (SQLException e) {
			throw new CustomException("Error occured." , e);
		}
//		while(rSet.next()){
//			Map<String,String> map = createLinkedMap();
//			String id = rSet.getString("EMPLOYEE_ID");
//			map.put("EMPLOYEE_ID", id);
//			String name = rSet.getString("NAME");
//			map.put("EMPLOYEE NAME", name);
//			String personID = rSet.getString("ID");
//			map.put("DEPENDENT ID", personID);
//			String dName = rSet.getString("DEP_NAME");
//			map.put("DEPENDENT NAME", dName);
//			String age = rSet.getString("AGE");
//			map.put("AGE", age);
//			String relate = rSet.getString("RELATIONSHIP");
//			map.put("RELATIONSHIP", relate);
//			String gen = rSet.getString("GENDER");
//			map.put("GENDER", gen);
//			list.add(map);
//		}
		return list;
	}
	
	// experiment 12
	public List<Map<String,String>> matchAscending(int limit) throws CustomException {
		
		String query = "SELECT EMPLOYER_POJO.EMPLOYEE_ID,EMPLOYER_POJO.NAME,DEPENDENT.* FROM EMPLOYER_POJO "
				+ "LEFT JOIN DEPENDENT ON EMPLOYER_POJO.EMPLOYEE_ID=DEPENDENT.ID "
				+ "WHERE EMPLOYER_POJO.EMPLOYEE_ID IN (" + getNEmployeeId(limit) 
				+ ") ORDER BY EMPLOYER_POJO.NAME ASC";
		
		List<Map<String,String>> input = createArrayList();
		
		try (PreparedStatement prepStat = getConnection().prepareStatement(query);){

			try (ResultSet rSet = prepStat.executeQuery();){
					
				input = printMatchSet(rSet);
				
			}
		} catch (SQLException e) {
			throw new CustomException("Error occured." , e);
		}
		
		return input;
	}
	
	public StringBuilder getNEmployeeId(int limit) throws CustomException {
		String query = "SELECT EMPLOYER_POJO.EMPLOYEE_ID FROM EMPLOYER_POJO LIMIT "+limit;
		StringBuilder builderId = new StringBuilder();
		
		try (PreparedStatement prepStat = getConnection().prepareStatement(query);){
			try (ResultSet rSet = prepStat.executeQuery();){
				
				builderId = appendID(rSet, limit);

			}
		} catch (SQLException e) {
			throw new CustomException("Error occured." , e);
		}
		return builderId;
	}
	
	public StringBuilder appendID(ResultSet rSet, int limit) throws CustomException {
		
		MyUtil.checkNull(rSet);
		
		List<String> list = createArrayList();
		StringBuilder ID = new StringBuilder();
		
		try {
			while(rSet.next()) {
				String id = rSet.getString("EMPLOYEE_ID"); // EMPLOYEE_ID or 1
				list.add(id);
			}
		for(int i=0; i<limit; i++) {
			if(i == limit-1) {
				ID.append(list.get(i));
			} else {
				ID.append(list.get(i)).append(',');
			}
		}
		} catch (SQLException e) {
			throw new CustomException("Error occured." , e);
		}
		return ID;
	}
}
