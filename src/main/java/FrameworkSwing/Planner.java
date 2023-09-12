package FrameworkSwing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import javassist.CannotCompileException;
import javassist.NotFoundException;


public class Planner {
	public ArrayList<JRadioButton> tactic=new ArrayList<JRadioButton>();
	public HashMap<String, String>chosen=new HashMap<String,String>();
	JButton execute=new JButton("Execute plan ");
	public HashMap<String, ArrayList<JRadioButton>>planed=new HashMap<String, ArrayList<JRadioButton>>();
	public void View(SelectedTactiqueForFeature selected) {
		
		/* * ****************************************************  JFrame  *********************************************** */
		JFrame frame3 = new JFrame("Planner component");
		JPanel pane=new JPanel();
		frame3.setContentPane(pane);
		frame3.setSize(1000, 1000);
		
		/* * ****************************************************  JTable  *********************************************** */
		Object[] columns = new String[] {
	            "Feature","Selected-tactics"
	        };
		
		/* * ****************************************************  Get selected tactic for each feature  *********************************************** */
		Iterator<Entry<String, ArrayList<String>>> it = selected.getTactiquefeature().entrySet().iterator();
		
		while (it.hasNext()) {
			Map.Entry<String, ArrayList<String>> m = it.next();
			String key = m.getKey().toString();
			JLabel featurename=new JLabel();
			featurename.setText(key);
			pane.add(featurename);
			ArrayList<String> value = m.getValue();
			ArrayList<JRadioButton>b=new ArrayList<JRadioButton>();
			for(int i=0;i<value.size();i++) {
				JRadioButton box=new JRadioButton(value.get(i).toString());
				b.add(box);
				pane.add(box);
				//listeoftactiques.put(key,box);
				tactic.add(box);

			}
			
			planed.put(key, b);
			

		}
	
		pane.add(execute);
		// Root Item

		
		frame3.setVisible(true);
		execute.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Iterator<Entry<String, ArrayList<JRadioButton>>> it2 = planed.entrySet().iterator();
				while(it2.hasNext()) {
					Entry<String, ArrayList<JRadioButton>> m=it2.next();
					String key=m.getKey();
				
					//System.out.println("tactique   "+m.getValue().getText()+" for "+key);
					for(int i=0;i<m.getValue().size();i++) {
						if(m.getValue().get(i).isSelected()==true) {
							String v=m.getValue().get(i).getText();
							chosen.put(key, v);
							System.out.println("is selected true tactique   "+v+" for "+key);
							try {
								new Executor(chosen);
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (CannotCompileException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}

						}	
					}
				
					
				}
		
			}
		});
		

	}

}
