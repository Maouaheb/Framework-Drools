package FrameworkSwing;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Zbel$ {

	public static void main(String[] args) throws IOException {
		Path temp = Files.move 
		        (Paths.get("C:\\Users\\belarbim\\Desktop\\Strategy.txt"),  
		        Paths.get("C:\\Users\\belarbim\\WeatherForecastEclipse\\framework-rules\\src\\main\\java\\FrameworkSwing\\Strategy.txt"));
	}

}
