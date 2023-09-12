package UnmarshallingPhase;

import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.bind.annotation.XmlAttribute;


public class Feature {
	public HashMap<String, String> getSubFeatureSet() {
		return SubFeatureSet;
	}

	public void setSubFeatureSet(HashMap<String, String> subFeatureSet) {
		SubFeatureSet = subFeatureSet;
	}

	private String name;
	private String type;
	private String card;
	private String constraint;
	private ArrayList<String> attributes;
	public ArrayList<String> getAttributes() {
		return attributes;
	}
	public void setAttributes(ArrayList<String> att) {
		this.attributes=att;
	}
	private HashMap<String, String>SubFeatureSet;
	public String getConstraint() {
		return constraint;
	}

	public void setConstraint(String constraint) {
		this.constraint = constraint;
	}
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	@XmlAttribute(name="cardinality")
	public String getCard() {
		return card;
	}
	public void setCard(String card) {
		this.card=card;
	}
	@XmlAttribute(name="name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Feature(String name, String type) {
		this.name = name;
		this.type = type;
	}

	public Feature(String name, HashMap<String, String> set) {
		this.name = name;
		this.SubFeatureSet = set;
	}

	public Feature(String name) {
		this.name = name;
	}
	public Feature() {
	}

}