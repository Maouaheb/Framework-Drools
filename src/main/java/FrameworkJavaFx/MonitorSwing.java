package FrameworkJavaFx;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import javafx.scene.control.MenuItem;


public class MonitorSwing extends JFrame {
	JMenu bindingchoix;
	Analyzer p;
	private String binding;
	tactiqueProperties t;
	JMenu granularitychoix;
	JMenu evolutionchoix;
	Boolean treated;
	JFrame frame;
	public boolean Editt(final String nameFeature, final SelectedTactiqueForFeature selected) {
		p=new Analyzer();
		JMenuBar menu=new JMenuBar();
	    menu.setLayout(new GridLayout(0,1));
	    frame=new JFrame("Monitor");
	    /* *********************************************************** Feature Types  ***************************************************************** */
	    JCheckBox type=new JCheckBox();
	    JCheckBox interne=new JCheckBox("internal");
	    JCheckBox externe=new JCheckBox("external");
	    frame.add(externe, BorderLayout.CENTER);
	    frame.add(interne, BorderLayout.WEST);

	    /* *********************************************************** Binding time choices  ***************************************************************** */
		bindingchoix=new JMenu("Binding-time");
		final JMenuItem compiletime = new JMenuItem("Compile-time");
		final JMenuItem runtime = new JMenuItem("Run-time");
		final JMenuItem designtime = new JMenuItem("Design-time"); 
		final JMenuItem installtime = new JMenuItem("install-time");
		final JMenuItem constructiontime = new JMenuItem("Construction-time");
		final JMenuItem loadtime = new JMenuItem("Loading-time");
		bindingchoix.add(compiletime);
		bindingchoix.add(runtime);
		bindingchoix.add(designtime);
		bindingchoix.add(installtime);
		bindingchoix.add(constructiontime);
		bindingchoix.add(loadtime);
		menu.add(bindingchoix);
		loadtime.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			bindingchoix.setText(loadtime.getText());	
			p.setBindingtime(loadtime.getText());
			}
		});
		constructiontime.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			bindingchoix.setText(constructiontime.getText());	
			p.setBindingtime(constructiontime.getText());
			}
		});
		
		compiletime.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			bindingchoix.setText(compiletime.getText());	
			p.setBindingtime(compiletime.getText());
			}
		});
	   runtime.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			bindingchoix.setText(runtime.getText());	
			p.setBindingtime(runtime.getText());

			}
		});
	   designtime.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			bindingchoix.setText(designtime.getText());	
			p.setBindingtime(designtime.getText());

			}
		});
	   installtime.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			bindingchoix.setText(installtime.getText());	
			p.setBindingtime(installtime.getText());

			
		}
	});
	    /* *********************************************************** granularity choices  ***************************************************************** */

	    granularitychoix=new JMenu("Granularity");
	   final JMenuItem fine = new JMenuItem("Fine");
		final JMenuItem coarse = new JMenuItem("Coarse");
		final JMenuItem medium = new JMenuItem("Medium");
		final JMenuItem any=new JMenuItem("Any");
		granularitychoix.add(fine);
		granularitychoix.add(coarse);
		granularitychoix.add(medium);
		granularitychoix.add(any);
		menu.add(granularitychoix);
		fine.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			granularitychoix.setText(fine.getText());	
			p.setGranularity(fine.getText());
			}
		});
		coarse.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			granularitychoix.setText(coarse.getText());	
			p.setGranularity(coarse.getText());

			}
		});
		medium.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			granularitychoix.setText(medium.getText());	
			p.setGranularity(medium.getText());

			}
		});
		any.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			granularitychoix.setText(any.getText());
			p.setGranularity(any.getText());

			}
		});
	    /* *********************************************************** evolution choices  ***************************************************************** */
		evolutionchoix=new JMenu("Evolution");
		final JMenuItem open = new JMenuItem("Open");
		final JMenuItem close = new JMenuItem("Close");
		evolutionchoix.add(open);
		evolutionchoix.add(close);
		menu.add(evolutionchoix);
		open.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				evolutionchoix.setText(open.getText());	
				p.setEvolution(open.getText());

			}
		});
		close.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				evolutionchoix.setText(close.getText());
				p.setEvolution(close.getText());


			}
		});
		 /* *********************************************************** JFrame caracteristics  ***************************************************************** */

		frame.setTitle("Annotate feature");
		frame.setSize(300, 250);
		frame.getContentPane().add(menu,BorderLayout.SOUTH);
		frame.setVisible(true);

	    /* *********************************************************** JButton submit caracteristics  ***************************************************************** */

		JButton submit=new JButton("submit");
		menu.add(submit);
		submit.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				frame.setVisible(false);
				p.bindingtime(p.getBindingtime(), p.getGranularity(), p.getEvolution(), nameFeature, selected);
				treated=true;
				
			}
		});
	   
		return true;
	}
	
}

