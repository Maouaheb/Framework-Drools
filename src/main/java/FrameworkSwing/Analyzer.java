package FrameworkSwing;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;

import org.drools.compiler.compiler.DroolsParserException;
import org.drools.compiler.compiler.PackageBuilder;
import org.drools.core.RuleBase;
import org.drools.core.RuleBaseFactory;
import org.drools.core.WorkingMemory;

public class Analyzer {
	private String bindingtime;
	private String granularity;
	private String evolution;

	public String getBindingtime() {
		return bindingtime;
	}

	public void setBindingtime(String bindingtime) {
		this.bindingtime = bindingtime;
	}

	public String getGranularity() {
		return granularity;
	}

	public void setGranularity(String granularity) {
		this.granularity = granularity;
	}

	public String getEvolution() {
		return evolution;
	}

	public void setEvolution(String evolution) {
		this.evolution = evolution;
	}

	public void bindingtime(String Bindingtime, String granularity, String evolution, String feature,
			SelectedTactiqueForFeature selected)   {
		PackageBuilder packageBuilder = new PackageBuilder();

		String ruleFile = "/com/rule/Rules2.drl";
		InputStream resourceAsStream = getClass().getResourceAsStream(ruleFile);

		Reader reader = new InputStreamReader(resourceAsStream);
		try {
			packageBuilder.addPackageFromDrl(reader);
		} catch (DroolsParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		org.drools.core.rule.Package rulesPackage = packageBuilder.getPackage();
		RuleBase ruleBase = RuleBaseFactory.newRuleBase();
		ruleBase.addPackage(rulesPackage);

		WorkingMemory workingMemory = ruleBase.newStatefulSession();
		tactiqueProperties t = new tactiqueProperties();
		t.setBindingtime(Bindingtime);
		t.setGranularity(granularity);
		t.setEvolution(evolution);
		workingMemory.insert(t);
		workingMemory.fireAllRules();
	System.out.println("The tactique for  "+feature+"" + t.getBindingtime() + "  " + t.getEvolution() + "  "
				+ t.getGranularity() + " is " + t.getTabletactique().size());
		selected.add(feature, t.getTabletactique());
		

	}

}
