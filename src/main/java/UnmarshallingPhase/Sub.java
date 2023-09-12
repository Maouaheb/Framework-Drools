package UnmarshallingPhase;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Sub {
	private ArrayList<Feature> feature;
	private String NameOfFeature;
	private String mandatory;
	private ArrayList<Sub> loopSub;
	private HashSet<OrSet> orSets;
	private HashSet<XorSet> xorSets;
	private String card;
	private String constraintType;
	private String constrainedClass;
	private ArrayList<String> attributes;
	public ArrayList<String> getAttributes() {
		return attributes;
	}
	public void setAttributes(ArrayList<String> att) {
		this.attributes=att;
	}
	public String getConstraintType() {
		return constraintType;
	}

	public void setConstraintType(String constraint) {
		this.constraintType = constraint;
	}
	public String getConstrainedClass() {
		return constrainedClass;
	}

	public void setConstrainedClass(String constraint) {
		this.constrainedClass = constraint;
	}
	public String getCard() {
		return card;
		
	}
	public void setCard(String card) {
		this.card=card;
	}
	public HashSet<XorSet> getXorSets() {
		return xorSets;
	}

	public void setXorSets(HashSet<XorSet> xorSets) {
		this.xorSets = xorSets;
	}

	public HashSet<OrSet> getOrSets() {
		return orSets;
	}

	public void setOrSets(HashSet<OrSet> orSets) {
		this.orSets = orSets;
	}

	public void addXOrSets(XorSet xor) {
		this.xorSets.add(xor);
	}

	public ArrayList<Sub> getLoopSub() {
		return loopSub;
	}

	public void setLoopSub(ArrayList<Sub> loopSub) {
		this.loopSub = loopSub;
	}

	public void addLoopSub(Sub s) {
		loopSub.add(s);
	}
	@XmlElement(name="feature")

	public ArrayList<Feature> getFeature() {
		return feature;
	}

	public void setFeature(ArrayList<Feature> feature2) {
		this.feature = feature2;
	}
	@XmlAttribute(name="name")
	public String getNameOfFeature() {
		return NameOfFeature;
	}

	public void setNameOfFeature(String nameOfFeature) {
		NameOfFeature = nameOfFeature;
	}

	public String getMandatory() {
		return mandatory;
	}

	public void setMandatory(String mandatory) {
		this.mandatory = mandatory;
	}

	public Sub(ArrayList<Feature> feature, String nameOfFeature, String mandatory) {
		super();
		this.feature = feature;
		NameOfFeature = nameOfFeature;
		this.mandatory = mandatory;
	}

	public Sub(ArrayList<Feature> feature, String nameOfFeature) {
		super();
		this.feature = feature;
		NameOfFeature = nameOfFeature;
	}

	public Sub(ArrayList<Feature> feature, String nameOfFeature, String mandatory, ArrayList<Sub> loopSub) {
		super();
		this.feature = feature;
		NameOfFeature = nameOfFeature;
		this.mandatory = mandatory;
		this.loopSub = loopSub;
	}

	public Sub(String name) {
		this.NameOfFeature = name;
	}

	public Sub(String name, String mandatory) {
		this.NameOfFeature = name;
		this.mandatory = mandatory;
	}

	public Sub() {

	}
}
