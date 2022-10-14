package runner.jdbc;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import beginner.methods.jdbc.DependentPojo;
import beginner.methods.jdbc.JdbcMethods;
import myutil.CustomException;
import myutil.MyUtil;

public class JdbcRunner {
	
	public static void printList(List<?> list) {
		int len = list.size();
		for(int i = 0; i<len ; i++) {
			logger.info(list.get(i).toString());
		}
	}
	
	private static final Logger logger = Logger.getLogger(JdbcRunner.class.getName());
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		JdbcMethods helperObj = new JdbcMethods();
		System.out.print("Enter the experiment : ");
		int choice = MyUtil.checkInt(scan);
		
		try {
			switch (choice) {
			case 1: {
				logger.info("Enter the table name to create : ");
				String table = scan.next();
				helperObj.createTable(table);
				break;
			}
			case 2: {
				logger.info("Enter the table name to insert : ");
				String table = scan.next();
				logger.info("How many details do you want to add.");
				int num = MyUtil.checkInt(scan);
				List<List<String>> input = helperObj.createArrayList();
				for(int i = 0; i < num; i++) {
					List<String> list = helperObj.createArrayList();
					logger.info("Enter Employee ID : ");
					Integer id = MyUtil.checkInt(scan);
					list.add(id.toString());
					logger.info("Enter Employee Name : ");
					String name = scan.next();
					list.add(name);
					logger.info("Enter Employee Mobile No. : ");
					String mobNum = scan.next();
					list.add(mobNum);
					logger.info("Enter Employee Email : ");
					String email = scan.next();
					list.add(email);
					logger.info("Enter Employee Department : ");
					String dep = scan.next();
					list.add(dep);
					input.add(list);
				}
				helperObj.insertData(table, input, num);
//				logger.info("Enter the table name to insert : ");
//				String table = scan.next();
//				logger.info("How many details do you want to add.");
//				int num = MyUtil.checkInt(scan);
//				List<EmployeePojo> list = helperObj.createArrayList();
//				for(int i = 0; i < num; i++) {
//					logger.info("New Employee details -");
//					EmployeePojo obj = new EmployeePojo();
//					logger.info("Enter Employee ID : ");
//					String id = scan.next();
//					obj.setId(id);
//					scan.nextLine();
//					logger.info("Enter Employee Name : ");
//					String name = scan.nextLine();
//					obj.setEmpName(name);
//					logger.info("Enter Employee Mobile No. : ");
//					String mobNum = scan.next();
//					obj.setMobile(mobNum);
//					logger.info("Enter Employee Email : ");
//					String email = scan.next();
//					obj.setEmail(email);
//					logger.info("Enter Employee Department : ");
//					String dep = scan.next();
//					obj.setDepartment(dep);
//					list.add(obj);
//				}
//				helperObj.insertPojoData(table, list);
				break;
			}
			case 3: {
//				List<String> list = helperObj.createArrayList();
//				logger.info("Enter table name to retrieve data : ");
//				String table = scan.next();
//				logger.info("Enter the employee name to search : ");
//				String name = scan.next();
//				logger.info("Enter the corresponding employee ID : ");
//				int id = MyUtil.checkInt(scan);
//				list = helperObj.selectData(list, table, name, id);
//				logger.info(list.toString());
				Map<Integer,Map<String, String>> map = helperObj.createLinkedMap();
				logger.info("Enter table name to retrieve data : ");
				String table = scan.next();
				logger.info("Enter the employee name to search : ");
				String name = scan.next();
				logger.info("Enter the corresponding employee ID : ");
				int id = MyUtil.checkInt(scan);
				map = helperObj.selectPojoData(table, name, id);
				helperObj.printMap(map);
				break;
			}
			case 4: {
				logger.info("Enter table name to alter data : ");
				String table = scan.next();
				logger.info("Enter the corresponding employee ID : ");
				int id = MyUtil.checkInt(scan);
				logger.info("Enter column name to change : ");
				String column = scan.next();
				logger.info("Enter the data to update : ");
				String data = scan.next();
				helperObj.updateData(table, column, data, id);
				break;
			}
			case 5: {
//				logger.info("Enter table name to retrieve data : ");
//				String table = scan.next();
//				logger.info("Enter the no. of rows to fetch : ");
//				int limit = MyUtil.checkInt(scan);
//				List<Map<String,String>> list = helperObj.fetchRows(table, limit);
//				logger.info(list.toString());
				logger.info("Enter table name to retrieve data : ");
				String table = scan.next();
				logger.info("Enter the no. of rows to fetch : ");
				int limit = MyUtil.checkInt(scan);
				Map<Integer, Map<String, String>> map = helperObj.fetchRowsPojo(table, limit);
				helperObj.printMap(map);
				break;
			}
			case 6: {
//				logger.info("Enter table name to retrieve data : ");
//				String table = scan.next();
//				logger.info("Enter the no. of rows to fetch in descending order : ");
//				int limit = MyUtil.checkInt(scan);
//				List<Map<String,String>> list = helperObj.descendData(table, limit);
//				logger.info(list.toString());
				logger.info("Enter table name to retrieve data : ");
				String table = scan.next();
				logger.info("Enter the no. of rows to fetch in descending order : ");
				int limit = MyUtil.checkInt(scan);
				Map<Integer, Map<String, String>> map = helperObj.descendDataPojo(table, limit);
				helperObj.printMap(map);
				break;
			}
			case 7: {
				logger.info("Enter table name to delete data : ");
				String table = scan.next();
				logger.info("Enter the corresponding employee ID : ");
				String id = scan.next();
				helperObj.deleteData(table, id);
				logger.info("Enter the no. of rows to fetch : ");
				int limit = MyUtil.checkInt(scan);
				List<Map<String,String>> list = helperObj.fetchRows(table, limit);
				printList(list);
				break;
			}
			case 8: {
				logger.info("Repeat 2,3,5 & 6th experiments.");
				break;
			}
			case 9: {
				logger.info("Enter dependent table name :");
				String dependent = scan.next();
				logger.info("Enter parent table name :");
				String parent = scan.next();
				logger.info("Enter the foreign key :");
				String key = scan.next();
				helperObj.createDependent(dependent, parent, key);
				break;
			}
			case 10: {
				logger.info("Enter the dependent table name to insert : ");
				String table = scan.next();
				logger.info("How many details do you want to add : ");
				int num = MyUtil.checkInt(scan);
				List<DependentPojo> list = helperObj.createArrayList();
				for(int i = 0; i < num; i++) {
					logger.info("New Dependent details -");
					DependentPojo obj = new DependentPojo();
					logger.info("Enter Dependent ID : ");
					String id = scan.next();
					obj.setID(id);
					scan.nextLine();
					logger.info("Enter Dependent Name : ");
					String name = scan.nextLine();
					obj.setPersonName(name);
					logger.info("Enter Dependent Age : ");
					String age = scan.next();
					obj.setAge(age);
					logger.info("Enter Dependent Relationship : ");
					String relation = scan.next();
					obj.setRelationship(relation);
					logger.info("Enter Dependent Gender : ");
					String gen = scan.next();
					obj.setGender(gen);
					list.add(obj);
				}
				helperObj.insertDependentData(table, list);
				break;
			}
			case 11: {
				logger.info("Enter the EMPLOYEE_ID to fetch dependent details : ");
				int id = MyUtil.checkInt(scan);
				List<Map<String,String>> list = helperObj.fetchMatching(id);
				logger.info(list.toString());
				break;
			}
			case 12: {
				logger.info("Enter the limit to fetch dependent details in ascending order : ");
				int limit = MyUtil.checkInt(scan);
				List<Map<String,String>> list = helperObj.matchAscending(limit);
				printList(list);
				break;
			}
			default:
				System.out.println("No matching case.");
			}
		} catch (CustomException e) {
			logger.log(Level.SEVERE, "Exception Occured : ", e);
		}
	}
}
