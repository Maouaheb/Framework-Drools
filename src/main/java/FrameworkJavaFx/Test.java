package FrameworkJavaFx;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.collections15.Transformer;

import UnmarshallingPhase.Feature;
import UnmarshallingPhase.MainAnd;
import UnmarshallingPhase.OrSet;
import UnmarshallingPhase.XorSet;
import UnmarshallingPhase.featureModel;
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

public class Test {
	public static SelectedTactiqueForFeature selected = new SelectedTactiqueForFeature();

	public static PickedState<String> pickedState;

	private static void initAndShowGUI() {
		// This method is invoked on the EDT thread
		Graph<String, String> g = new DelegateForest<String, String>();

		String fileName = "C:/Users/belarbim/WeatherForecastEclipse/framework-rules/src/main/java/GeneratedFiles/shop.xml";

		File xmlFile = new File(fileName);

		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(featureModel.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			featureModel featuremodel = (featureModel) jaxbUnmarshaller.unmarshal(xmlFile);
			MainAnd root = featuremodel.getStruct().getAnd();
			// add root node
			g.addVertex(featuremodel.getStruct().getAnd().getName());
			System.out.println(featuremodel.getStruct().getAnd().getName());
			if (featuremodel.getStruct().getAnd().getXorSets().size() > 0) {
				for (int i = 0; i < featuremodel.getStruct().getAnd().getXorSets().size(); i++) {
					XorSet xor = featuremodel.getStruct().getAnd().getXorSets().get(i);
					// add xor node
					g.addVertex(xor.getNameOfFeature());
					g.addEdge(Integer.toString(i), featuremodel.getStruct().getAnd().getName(), xor.getNameOfFeature());
					// add leafs to the xor variation points
					if (xor.getFeature().size() > 0) {
						// System.out.println(xor.getNameOfFeature());
						for (int j = 0; j < xor.getFeature().size(); j++) {
							ArrayList<Feature> featuresFeuilles = xor.getFeature();
							g.addVertex(featuresFeuilles.get(j).getName());
							g.addEdge(featuresFeuilles.get(j).getName().concat(Integer.toString(j)),
									xor.getNameOfFeature(), featuresFeuilles.get(j).getName());
						}
					}
					// add or variation points to the xor variation points (the parents)
					if (xor.getOrSet() != null) {

						if (xor.getOrSet().size() > 0) {
							for (int k = 0; k < xor.getOrSet().size(); k++) {
								ArrayList<OrSet> orList = xor.getOrSet();
								// tracer les noeuds des feuilles features
								g.addVertex(orList.get(k).getNameOfFeature());
								// tracer les arcs entre feuilles features et leurs parent xor noeuds
								g.addEdge(orList.get(k).getNameOfFeature().concat(Integer.toString(k)),
										xor.getNameOfFeature(), orList.get(k).getNameOfFeature());
								// add variants to the or variation points (retrieved above)
								OrSet ornode = orList.get(k);
								// get all the variants
								if (ornode.getFeature().size() > 0) {
									for (int m = 0; m < ornode.getFeature().size(); m++) {
										ArrayList<Feature> featuresFeuilles = ornode.getFeature();
										g.addVertex(featuresFeuilles.get(m).getName());
										g.addEdge(featuresFeuilles.get(m).getName().concat(Integer.toString(m)),
												ornode.getNameOfFeature(), featuresFeuilles.get(m).getName());
									}
								}

							}

						}
					}
				}
			}

			/*
			 * for (int i = 0; i < featuremodel.getStruct().getAnd().getLevel().size(); i++)
			 * { Sub and = featuremodel.getStruct().getAnd().getLevel().get(i);
			 * ArrayList<Feature> featuresFeuilles =
			 * featuremodel.getStruct().getAnd().getFeature();
			 * g.addVertex(and.getNameOfFeature()); g.addEdge(Integer.toString(i),
			 * featuremodel.getStruct().getAnd().getName(), and.getNameOfFeature()); for
			 * (int k = 0; k < featuresFeuilles.size(); k++) {
			 * g.addVertex(featuresFeuilles.get(k).getName());
			 * g.addEdge(featuresFeuilles.get(k).getName().concat(Integer.toString(k)),
			 * featuremodel.getStruct().getAnd().getName(),
			 * featuresFeuilles.get(k).getName()); } ArrayList<Feature> feature =
			 * and.getFeature(); for (int j = 0; j < feature.size(); j++) {
			 * System.out.println("Le feature  " + feature.get(j).getName());
			 * g.addVertex(feature.get(j).getName());
			 * g.addEdge(feature.get(j).getName().concat(Integer.toString(j)),
			 * and.getNameOfFeature(), feature.get(j).getName()); } }
			 */
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		Transformer<String, String> transformer = new Transformer<String, String>() {

			public String transform(String arg0) {
				return arg0.toString();

			}

		};
		TreeLayout<String, String> layout3 = new TreeLayout((Forest<String, String>) g, 50, 50);

		VisualizationViewer<String, String> vv3 = new VisualizationViewer<String, String>(layout3);
		// vv3.setSize(2, 2);
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
		/*
		 * *********************************************rendre chaque noeud du graphe
		 * cliquable ************************************************************
		 */

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
						MonitorSwing m = new MonitorSwing();
						m.Editt(vertex, selected);
					}
				}
			}
		});
		/*
		 * Transformer<String, String> transformer = new Transformer<String, String>() {
		 * 
		 * public String transform(String arg0) { return arg0.toString(); }
		 * 
		 * };
		 * 
		 * 
		 * 
		 * 
		 * Layout<String, String> layout3 = new TreeLayout((Forest<String, String>) g);
		 * VisualizationViewer<String, String> vv3 = new VisualizationViewer<String,
		 * String>(layout3);
		 * 
		 * vv3.getRenderContext().setVertexLabelTransformer(transformer); final
		 * DefaultModalGraphMouse<String, Number> graphMouse3 = new
		 * DefaultModalGraphMouse<String, Number>(); vv3.setGraphMouse(graphMouse3);
		 * graphMouse3.setMode(Mode.PICKING); pickedState = vv3.getPickedVertexState();
		 * Test.pickedState.addItemListener(new ItemListener() {
		 * 
		 * public void itemStateChanged(ItemEvent e) { final Object object =
		 * e.getItem(); // TODO Auto-generated method stub Platform.runLater(new
		 * Runnable() { public void run() { Monitor m = new Monitor();
		 * m.Editt(object.toString(), selected);
		 * System.out.println("selected **********************" + object.toString()); }
		 * }); } });
		 */
		JFrame frame = new JFrame("Pas 3");
		JButton submit = new JButton("Go to plan");
		frame.getContentPane().add(vv3);
		submit.setBounds(50, 150, 100, 30);
		final JFXPanel fxPanel = new JFXPanel();
		submit.setSize(1, 1);
		submit.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				PlannerSwing p = new PlannerSwing();
				p.View(selected);

			}
		});
		JLabel bottomLabel = new JLabel("The monitoring phase: click on feature to anotate it", SwingConstants.CENTER);
		frame.add(bottomLabel, BorderLayout.BEFORE_FIRST_LINE);
		frame.add(submit, BorderLayout.SOUTH);
		frame.setSize(800, 600);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	// This method is invoked on the JavaFX thread

	public static void main(String[] args) {
		initAndShowGUI();

	}
}
