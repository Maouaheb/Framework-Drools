package UnmarshallingPhase;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class XorSet {
	private ArrayList<Feature> feature;
	private String NameOfFeature;
	private ArrayList<Sub> loopSub;
	private ArrayList<OrSet> orSet;
	private HashSet<XorSet> xorSet;
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
	@XmlElement(name="alt")
	public HashSet<XorSet> getXorSet() {
		return xorSet;
	}

	public void setXorSet(HashSet<XorSet> xorsett) {
		this.xorSet = xorsett;
	}

	public void addLoopSub(Sub s) {
		this.loopSub.add(s);
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

	public ArrayList<Sub> getLoopSub() {
		return loopSub;
	}

	public void setLoopSub(ArrayList<Sub> loopSub) {
		this.loopSub = loopSub;
	}
	@XmlElement(name="or")
	public ArrayList<OrSet> getOrSet() {
		return orSet;
	}

	public void setOrSet(ArrayList<OrSet> orsett2) {
		this.orSet = orsett2;
	}

	public XorSet(String nameFeature, ArrayList<Feature> feature) {
		this.NameOfFeature = nameFeature;
		this.feature = feature;
	}
	public XorSet(String nameFeature, ArrayList<Feature> feature, ArrayList<OrSet>orset) {
		this.NameOfFeature = nameFeature;
		this.feature = feature;
		this.orSet=orset;
	}
	



	public XorSet(ArrayList<OrSet> orSet,String nameOfFeature) {
		super();
		NameOfFeature = nameOfFeature;
		this.orSet = orSet;
	}
	public XorSet(String nameFeature) {
		this.NameOfFeature = nameFeature;
	}
public XorSet() {
	
}
}
