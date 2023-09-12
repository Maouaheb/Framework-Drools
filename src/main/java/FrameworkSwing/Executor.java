package FrameworkSwing;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import javassist.CannotCompileException;
import javassist.NotFoundException;

public class Executor {
	public File file;
public Executor(HashMap<String, String> chosen) throws  IOException, CannotCompileException {
	
	Iterator<Entry<String, String>> it = chosen.entrySet().iterator();
	while(it.hasNext()) {
		Entry<String, String> m=it.next();
		String key=m.getKey();
		String value=m.getValue();
		System.out.println(key+"    la clés est choisie pour la valeur suivante          "+value+"la taille "+chosen.size());
		generateAssets(key,value);
		


		
	}
	
}

public void generateAssets(String key, String value) throws IOException {
	// TODO Auto-generated method stub
	
}
}
