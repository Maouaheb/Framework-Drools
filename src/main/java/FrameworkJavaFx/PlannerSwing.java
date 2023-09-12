package FrameworkJavaFx;

import java.awt.BorderLayout;
import java.awt.GridLayout;
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
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

import javassist.CannotCompileException;
import javassist.NotFoundException;

public class PlannerSwing extends JFrame{
	JLabel bottomLabel = new JLabel("The Planner phase: Select programming tactic for each feature", SwingConstants.CENTER);

	public ArrayList<JRadioButton> tactic=new ArrayList<JRadioButton>();
	public HashMap<String, String>chosen=new HashMap<String,String>();
	JButton execute=new JButton("Execute plan ");
	public HashMap<String, ArrayList<JRadioButton>>planed=new HashMap<String, ArrayList<JRadioButton>>();
	public void View(SelectedTactiqueForFeature selected) {
		
		/* * ****************************************************  JFrame  *********************************************** */
		JFrame frame3 = new JFrame("Planner component");
		JPanel north=new JPanel();
		JPanel pane=new JPanel();
		pane.setLayout(new GridLayout());
		JPanel south=new JPanel();
		frame3.getContentPane().add(north, BorderLayout.NORTH);
		frame3.getContentPane().add(pane, BorderLayout.CENTER);
		frame3.getContentPane().add(south, BorderLayout.SOUTH);
		frame3.setSize(1000, 500);
		north.add(bottomLabel,BorderLayout.BEFORE_FIRST_LINE);
		/* * ****************************************************  JTable  *********************************************** */
		Object[] columns = new String[] {
	            "Feature","Selected-tactics"
	        };
		
		/* * ****************************************************  Get selected tactic for each feature  *********************************************** */
		Iterator<Entry<String, ArrayList<String>>> it = selected.getTactiquefeature().entrySet().iterator();
		JMenu menu=new JMenu();
		menu.setLayout(new GridLayout(0,1));
		while (it.hasNext()) {
			Map.Entry<String, ArrayList<String>> m = it.next();
			String key = m.getKey().toString();
			JLabel featurename=new JLabel();
			featurename.setText(key);
			pane.add(featurename);
			ArrayList<String> value = m.getValue();
			ArrayList<JRadioButton>b=new ArrayList<JRadioButton>();
			if(value.size()==0) {
				JRadioButton box=new JRadioButton("no available tactic");	
				b.add(box);
				box.setEnabled(false);
				pane.add(box);
				System.out.println("tactique   "+m.getValue().size()+" for "+key);

			}
				for(int i=0;i<value.size();i++) {
					JRadioButton box=new JRadioButton(value.get(i).toString());

					b.add(box);
					pane.add(box);
					//listeoftactiques.put(key,box);
					tactic.add(box);

				
			}

			
			planed.put(key, b);
			

		}
	
		south.add(execute);
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
							//System.out.println("is selected true tactique   "+v+" for "+key);
							try {
								try {
									new Executor(chosen);
								} catch (NotFoundException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
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
