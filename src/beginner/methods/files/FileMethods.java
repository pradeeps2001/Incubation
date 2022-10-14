package beginner.methods.files;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

import myutil.CustomException;
import myutil.MyUtil;

public class FileMethods {

	public void inputWriter(String fileName, String...input) throws IOException, CustomException {
		MyUtil.checkNull(fileName);
		try(FileWriter writer = new FileWriter(fileName);){
			for(String str : input) {
				writeData(writer,str);
			}
			writer.flush();
		}
	}
	
	public void writeData(FileWriter writer, String input) throws IOException, CustomException {
		MyUtil.checkNull(input);
		MyUtil.checkNull(writer);
		String newLine = "\n";
		writer.write(input + newLine);//swami
		//writer.flush();
	}
	
	public Properties storeProperty(String fileName, Properties prop) throws IOException, CustomException {
		MyUtil.checkNull(fileName);
		try(FileWriter writer = new FileWriter(fileName);){
			prop.store(writer, fileName);
			writer.flush();
		}
		return prop;
	}
	
	public Properties loadProperty(String fileName, Properties prop) throws IOException, CustomException {
		MyUtil.checkNull(fileName);
		try(FileReader reader = new FileReader(fileName);){
			prop.load(reader);
		}
		return prop; // swami
	}
	
	
	public boolean createFile(String directory) throws CustomException {
		MyUtil.checkNull(directory);
		File file = new File(directory);
		return file.mkdir();
	}
}
