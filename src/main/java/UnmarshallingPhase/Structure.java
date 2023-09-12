package UnmarshallingPhase;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

public class Structure {

	private MainAnd and;
	@XmlElement(name="and")
	public MainAnd getAnd() {
		return and;
	}

	public void setAnd(MainAnd and) {
		this.and = and;
	}
}
