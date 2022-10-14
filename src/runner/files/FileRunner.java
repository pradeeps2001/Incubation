package runner.files;

import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;
import java.util.logging.Logger;

import beginner.methods.files.FileMethods;
import beginner.methods.pojo.OverloadConstructor;
import myutil.CustomException;
import myutil.MyUtil;

public class FileRunner {

	private static final Logger logger = Logger.getLogger(FileRunner.class.getName());

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		FileMethods helperObj = new FileMethods();
		Scanner scan = new Scanner(System.in);
		String decision;
		do {
			System.out.print("Enter the experiment : ");
			int choice = MyUtil.checkInt(scan);
			try {
			switch (choice) {
			case 1: {
				logger.info("Enter the text file name : ");
				String fileName = scan.next();
				logger.info("Enter no. of lines to write in file : ");
				int num = MyUtil.checkInt(scan);
				helperObj.inputWriter(fileName, MyUtil.getStrInput(scan, num));
				break;
			}
			case 2: {
				logger.info("Enter the text file name : ");
				String fileName = scan.next();
				logger.info("Enter no. of properties to write in file : ");
				int num = MyUtil.checkInt(scan);
				Properties prop = new Properties();
				for(int i = 0; i < num; i++) {
					logger.info("Enter key " + (i+1));
					String key = scan.next();
					logger.info("Enter value " + (i+1));
					String value = scan.next();
					prop.setProperty(key, value);
				}
				prop = helperObj.storeProperty(fileName, prop);
//				logger.info("Enter keys : ");
//				String[] key = MyUtil.getStrInput(scan, num);
//				logger.info("Enter values : ");
//				String[] value = MyUtil.getStrInput(scan, num);
//				helperObj.setProperty(fileName, key, value);
				break;
			}
			case 3: {
				logger.info("Enter the text file name to read : ");
				String fileName = scan.next();
				Properties prop = new Properties();
				helperObj.loadProperty(fileName,prop);
				logger.info(prop.toString());
				break;
			}
			case 4: {
				logger.info("Enter a directory(/home/inc8/your_directory) to create : ");
				String directory = scan.next();
				if (helperObj.createFile(directory)) {
					logger.info("Directory created.");
				}
				else {
					logger.info("Default directory is selected.");
				}
				
				// experiment 1
				logger.info("Enter the text file name to write statements : ");
				String fileName = scan.next();
				logger.info("Enter no. of lines to write in file : ");
				int num = MyUtil.checkInt(scan);
				helperObj.inputWriter(fileName, MyUtil.getStrInput(scan, num));
				
				// experiment 2
				logger.info("Enter the text file name to add properties : ");
				String fileName2 = scan.next();
				logger.info("Enter no. of properties to write in file : ");
				int num2 = MyUtil.checkInt(scan);
				Properties prop = new Properties();
				for(int i = 0; i < num2; i++) {
					logger.info("Enter key " + (i+1));
					String key = scan.next();
					logger.info("Enter value " + (i+1));
					String value = scan.next();
					prop.setProperty(key, value);
				}
				prop = helperObj.storeProperty(fileName, prop);
				
				// experiment 3
				logger.info("Enter the text file name to read : ");
				String fileName3 = scan.next();
				Properties props = new Properties();
				helperObj.loadProperty(fileName3,props);
				logger.info(props.toString());
				break;
			}
			case 5: {
				OverloadConstructor obj = new OverloadConstructor("Hello");
				logger.info(obj.toString());
				break;
			}
			default:
				System.out.println("No matching case.");
			}
			} catch(IOException | CustomException e) {
				e.printStackTrace();
			}
			System.out.println("Do you want to retry : yes/no");
			decision = scan.next();
		} while (decision.equalsIgnoreCase("yes"));
	}
}
