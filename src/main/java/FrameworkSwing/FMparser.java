package FrameworkSwing;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.io.File;
import java.text.AttributedString;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import UnmarshallingPhase.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.apache.commons.collections15.Transformer;

import edu.uci.ics.jung.algorithms.layout.FRLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.algorithms.layout.TreeLayout;
import edu.uci.ics.jung.graph.DelegateForest;
import edu.uci.ics.jung.graph.Forest;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.visualization.VisualizationViewer;
import edu.uci.ics.jung.visualization.control.DefaultModalGraphMouse;
import edu.uci.ics.jung.visualization.control.GraphMouseListener;
import edu.uci.ics.jung.visualization.control.ModalGraphMouse.Mode;
import edu.uci.ics.jung.visualization.picking.PickedState;

public class FMparser {
	public SelectedTactiqueForFeature selected;
	public GridBagConstraints constraint;
	public static void main(String[] args) {
		String fileName = "C:/Users/belarbim/WeatherForecastEclipse/framework-rules/src/main/java/GeneratedFiles/hellopizza.xml";
		FMparser parser = new FMparser();
		parser.jaxbXmlFileToObject(fileName);

	}

	public void jaxbXmlFileToObject(String fileName) {
		selected = new SelectedTactiqueForFeature();
		Graph<String, String> g = new DelegateForest<String, String>();
		/*  **************************************************** Construction graph à partir du FM xml ************************************************************** */
		File xmlFile = new File(fileName);

		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(featureModel.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

			featureModel featuremodel = (featureModel) jaxbUnmarshaller.unmarshal(xmlFile);
			g.addVertex(featuremodel.getStruct().getAnd().getName());
			for (int i = 0; i < featuremodel.getStruct().getAnd().getLevel().size(); i++) {
				Sub and = featuremodel.getStruct().getAnd().getLevel().get(i);
				ArrayList<Feature> featuresFeuilles = featuremodel.getStruct().getAnd().getFeature();
				System.out.println("Le sub  " + and.getNameOfFeature());
				g.addVertex(and.getNameOfFeature());
				g.addEdge(Integer.toString(i), featuremodel.getStruct().getAnd().getName(), and.getNameOfFeature());
				for (int k = 0; k < featuresFeuilles.size(); k++) {
					g.addVertex(featuresFeuilles.get(k).getName());
					g.addEdge(featuresFeuilles.get(k).getName().concat(Integer.toString(k)),
							featuremodel.getStruct().getAnd().getName(), featuresFeuilles.get(k).getName());
				}
				ArrayList<Feature> feature = and.getFeature();
				for (int j = 0; j < feature.size(); j++) {
					System.out.println("Le feature  " + feature.get(j).getName());
					g.addVertex(feature.get(j).getName());
					g.addEdge(feature.get(j).getName().concat(Integer.toString(j)), and.getNameOfFeature(),
							feature.get(j).getName());
				}
			}
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		Transformer<String, String> transformer = new Transformer<String, String>() {

			public String transform(String arg0) {
				return arg0.toString();

			}

		};
		/* ********************************************Set size between nodes and edges of the graph ******************************************************* */
		TreeLayout<String, String> layout3 = new TreeLayout((Forest<String,String>) g, 100, 100);
;
		VisualizationViewer<String, String> vv3 = new VisualizationViewer<String, String>(layout3);
		//vv3.setSize(2, 2);
		vv3.getRenderContext().setVertexLabelTransformer(transformer);
		vv3.addGraphMouseListener(new GraphMouseListener<String>() {
			
			public void graphReleased(String arg0, MouseEvent arg1) {
				// TODO Auto-generated method stub

			}

			public void graphPressed(String arg0, MouseEvent arg1) {
				// TODO Auto-generated method stub

			}

			public void graphClicked(String arg0, MouseEvent arg1) {
				// TODO Auto-generated method stub

			}
		});
		final DefaultModalGraphMouse<String, Number> graphMouse3 = new DefaultModalGraphMouse<String, Number>();
		vv3.setGraphMouse(graphMouse3);
		graphMouse3.setMode(Mode.PICKING);
		final PickedState<String> pickedState = vv3.getPickedVertexState();
		/* *********************************************rendre chaque noeud du graphe cliquable ************************************************************ */

		// Attach the listener that will print when the vertices selection changes.
		pickedState.addItemListener(new ItemListener() {

			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				Object subject = e.getItem();
				// The graph uses Integers for vertices.
				if (subject instanceof String) {
					String vertex = (String) subject;
					if (pickedState.isPicked(vertex)) {
						System.out.println("Vertex " + vertex + " is now selected");
						Monitor m = new Monitor();
						m.Editt(vertex, selected);
					}
				}
			}
		});
		/* ************************************************* Planner Button  *********************************************/
		JPanel buttonPanel = new JPanel();
		JButton analysis=new JButton("result of analysis phase !");
		buttonPanel.add(analysis);
		analysis.setSize(1, 1);
		analysis.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Planner view=new Planner();
				view.View(selected);
				
			}
		});
		
		/* * ****************************************************  JFrame  *********************************************** */
		JFrame frame3 = new JFrame("FM parseur ");
		JPanel panel=new JPanel();
		panel.add(vv3);
		frame3.setContentPane(panel);
		frame3.add(analysis,BorderLayout.SOUTH);
		frame3.setSize(1000, 1000);
		frame3.setVisible(true);

	}
}
