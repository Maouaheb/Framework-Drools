package FrameworkJavaFx;

import java.util.ArrayList;

public class tactiqueProperties {
private String Bindingtime;
private String granularity;
private String evolution;
private String name;
private ArrayList<String> tabletactique= new ArrayList<String>();
public void addElement(String s) {
	tabletactique.add(s);
}
public ArrayList<String> getTabletactique() {
	return tabletactique;
}
public void setTabletactique(ArrayList<String> tabletactique) {
	this.tabletactique = tabletactique;
}
public String getName() {
	return name;
}
public String getEvolution() {
	return evolution;
}
public void setEvolution(String evolution) {
	this.evolution = evolution;
}
public void setName(String name) {
	this.name = name;
}
public String getBindingtime() {
	return Bindingtime;
}
public void setBindingtime(String bindingtime) {
	Bindingtime = bindingtime;
}
public String getGranularity() {
	return granularity;
}
public void setGranularity(String granularity) {
	this.granularity = granularity;
}

}
