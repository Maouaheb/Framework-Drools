package FrameworkJavaFx;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.CopyOption;
public class DbGenerator {
String db;
String root;
String pwd;
String port;

public DbGenerator(String db, String root, String pwd, String port) {
	this.db=db;
	this.root=root;
	this.pwd=pwd;
	this.port=port;
}
public DbGenerator() {
	
}
	public void generateFile() {
		boolean success = false;
		System.out.println("Enter path of directory to create");
		String dir = "C:/Users/belarbim/WeatherForecastEclipse/framework-rules/src/main/java/GeneratedFiles";
		// Creating new directory in Java, if it doesn't exists
		File directory = new File(dir);
		if (directory.exists()) {
			System.out.println("Directory already exists ...");
		} else {
			System.out.println("Directory not exists, creating now");
			success = directory.mkdir();
			if (success) {
				System.out.printf("Successfully created new directory : %s%n", dir);
			} else {
				System.out.printf("Failed to create new directory: %s%n", dir);
			}
		} // Creating new file in Java, only if not exists
		File f = new File("Connexion.java");
		if (f.exists()) {
			System.out.println("File already exists");
		} else {
			System.out.println("No such file exists, creating now");
			try {
				success = f.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (success) {
				System.out.printf("Successfully created new file: %s%n", f);
			} else {
				System.out.printf("Failed to create new file: %s%n", f);
			}
		} // close Scanner to prevent resource leak
	}
	public void Connexion() throws IOException {
		generateFile();
		File prototype = new File("C:/Users/belarbim/WeatherForecastEclipse/framework-rules/src/main/java/FrameworkJavaFx/PrototypeConnexion");
	
		File res = new File("C:/Users/belarbim/WeatherForecastEclipse/framework-rules/src/main/java/GeneratedFiles/PrototypeConnexion.java");
		 FileReader fin = null;
		try {
			fin = new FileReader("C:/Users/belarbim/WeatherForecastEclipse/framework-rules/src/main/java/FrameworkJavaFx/PrototypeConnexion");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		  FileWriter fout = new FileWriter("C:/Users/belarbim/WeatherForecastEclipse/framework-rules/src/main/java/GeneratedFiles/PrototypeConnexion.java", true);  
		  int c;  
		  while ((c = fin.read()) != -1) {  
		   fout.write(c);  
		  }  
		  System.out.println("Copy finish...");  
		  fin.close();  
		  fout.close();  
		 }  
	public static void main(String args[]) throws IOException {
		DbGenerator db=new DbGenerator("", "", "", "");
		db.Connexion();
	}
}


