package UnmarshallingPhase;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class MainAnd {
	private ArrayList<Feature> feature;
	private String abs;
	private String Root;
	private String mandatory;
	private ArrayList<Sub> level;
	private List<OrSet> orSets;
	private List<XorSet> xorSets;
	private String name;
	@XmlAttribute(name="name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setOrSets(List<OrSet> orSets) {
		this.orSets = orSets;
	}

	public void setXorSets(List<XorSet> xorSets) {
		this.xorSets = xorSets;
	}
	@XmlElement(name = "alt")
	public List<XorSet> getXorSets() {
		return xorSets;
	}
	@XmlElement(name = "or")
	public List<OrSet> getOrSets() {
		return orSets;
	}

	public MainAnd() {

	}

	public MainAnd(ArrayList<Feature> feature, String abs, String mandatory, String Root, ArrayList<Sub> liste) {
		this.abs = abs;
		this.feature = feature;
		this.mandatory = mandatory;
		this.Root = Root;
		this.level = liste;

	}
	@XmlElement(name = "feature")
	public ArrayList<Feature> getFeature() {
		return feature;
	}

	public void addOrList(OrSet or) {
		if (orSets == null) {
			orSets = new ArrayList<OrSet>();
		}
		this.orSets.add(or);
	}

	public void addXorList(XorSet xor) {
		if (xorSets == null) {
			xorSets = new ArrayList<XorSet>();
		}
		this.xorSets.add(xor);
	}

	
	public void setFeature(ArrayList<Feature> feature) {
		this.feature = feature;
	}

	public String getAbs() {
		return abs;
	}

	public void setAbs(String abs) {
		this.abs = abs;
	}

	public String getRoot() {
		return Root;
	}

	public void setRoot(String Root) {
		this.Root = Root;
	}

	public String getMandatory() {
		return mandatory;
	}

	public void setMandatory(String mandatory) {
		this.mandatory = mandatory;
	}
	@XmlElement(name="and")
	public ArrayList<Sub> getLevel() {
		return level;
	}

	public void setLevel(ArrayList<Sub> level) {
		this.level = level;
	}

}
