package FrameworkJavaFx;

import java.util.ArrayList;
import java.util.HashMap;

public class SelectedTactiqueForFeature {
	private HashMap<String, ArrayList<String>> tactiquefeature=new HashMap();
	
	
	public HashMap<String, ArrayList<String>> getTactiquefeature() {
		return tactiquefeature;
	}


	public void setTactiquefeature(HashMap<String, ArrayList<String>> tactiquefeature) {
		this.tactiquefeature = tactiquefeature;
	}


	public void add(String key,ArrayList<String> value) {
		tactiquefeature.put(key, value);
		System.out.println("The size of hashmap is"+tactiquefeature.size());
	}

}
