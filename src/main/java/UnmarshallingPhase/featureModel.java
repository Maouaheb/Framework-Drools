package UnmarshallingPhase;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="featureModel")
public class featureModel {
	
	private Structure struct;
	
	@XmlElement
	public Structure getStruct() {
		return struct;
	}

	
	public void setStruct(Structure struct) {
		this.struct = struct;
	}

	public featureModel() {

	}

	public featureModel(Structure struct) {
		super();
		this.struct = struct;
	}
}
