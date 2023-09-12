package UnmarshallingPhase;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class OrSet {
	private ArrayList<Feature> feature;
	private String NameOfFeature;
	private ArrayList<Sub> loopSub;
	private HashSet<OrSet> orSet;
	private HashSet<XorSet> xorSet;
	@XmlElement(name="alt")
	public HashSet<XorSet> getXorSet() {
		return xorSet;
	}
	public void setXorSet(HashSet<XorSet> xorSet) {
		this.xorSet = xorSet;
	}
	private String type;
	private String card;
	public String getCard() {
		return card;
		
	}
	public void setCard(String card) {
		this.card=card;
	}
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	@XmlElement(name="feature")
	public ArrayList<Feature> getFeature() {
		return feature;
	}

	public void setFeature(ArrayList<Feature> feature) {
		this.feature = feature;
	}
	@XmlAttribute(name="name")
	public String getNameOfFeature() {
		return NameOfFeature;
	}

	public void setNameOfFeature(String nameOfFeature) {
		NameOfFeature = nameOfFeature;
	}
	@XmlElement(name="and")
	public ArrayList<Sub> getLoopSub() {
		return loopSub;
	}

	public void setLoopSub(ArrayList<Sub> loopSub) {
		this.loopSub = loopSub;
	}

	public void addLoopSub(Sub s) {
		this.loopSub.add(s);
	}
	@XmlElement(name="or")
	public HashSet<OrSet> getOrSet() {
		return orSet;
	}

	public void setOrSet(HashSet<OrSet> orSet) {
		this.orSet = orSet;
	}

	public OrSet(String nameFeature, ArrayList<Feature> feature) {
		this.NameOfFeature = nameFeature;
		this.feature = feature;
	}

	public OrSet(String nameFeature) {
		this.NameOfFeature = nameFeature;
	}

	public void addToListOr(OrSet or) {
		orSet.add(or);
	}
	public OrSet() {
		
	}
}
