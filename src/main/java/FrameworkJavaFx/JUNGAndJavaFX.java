package FrameworkJavaFx;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.collections15.Transformer;

import UnmarshallingPhase.Feature;
import UnmarshallingPhase.Sub;
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
import javafx.application.Application;
import javafx.embed.swing.JFXPanel;
import javafx.embed.swing.SwingNode;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.shape.Circle;


/**
 *  A sample showing how to use JUNG's layout classes to position vertices
 * in a graph.
 * @author jeffreyguenther
 * @author timheng
 */
public class JUNGAndJavaFX extends Application {
public JFrame frame3;
public SelectedTactiqueForFeature selected=new SelectedTactiqueForFeature();
public boolean s;
    @Override
    public void start (Stage stage) {
    	
    	 Graph<String, String> g = new DelegateForest<String, String>();
    	   
         
         String fileName = "C:/Users/belarbim/WeatherForecastEclipse/framework-rules/src/main/java/GeneratedFiles/hellopizza.xml";

 		
         File xmlFile = new File(fileName);
          
         JAXBContext jaxbContext;
         try
         {
             jaxbContext = JAXBContext.newInstance(featureModel.class);
             Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
              
             featureModel featuremodel = (featureModel) jaxbUnmarshaller.unmarshal(xmlFile);
             g.addVertex(featuremodel.getStruct().getAnd().getName());
             for(int i=0;i<featuremodel.getStruct().getAnd().getLevel().size();i++) {
             	Sub and= featuremodel.getStruct().getAnd().getLevel().get(i);
             	ArrayList<Feature> featuresFeuilles=featuremodel.getStruct().getAnd().getFeature();
             	System.out.println("Le sub  "+and.getNameOfFeature());
             	g.addVertex(and.getNameOfFeature());
             	g.addEdge(Integer.toString(i),featuremodel.getStruct().getAnd().getName(), and.getNameOfFeature());
             	for(int k=0;k<featuresFeuilles.size();k++) {
             		g.addVertex(featuresFeuilles.get(k).getName());
                 	g.addEdge(featuresFeuilles.get(k).getName().concat(Integer.toString(k)),featuremodel.getStruct().getAnd().getName(),featuresFeuilles.get(k).getName());	
             	}
             	ArrayList<Feature> feature=and.getFeature();
             	for(int j=0; j<feature.size();j++) {
             		System.out.println("Le feature  "+feature.get(j).getName());
             		g.addVertex(feature.get(j).getName());
             		g.addEdge(feature.get(j).getName().concat(Integer.toString(j)),and.getNameOfFeature(),feature.get(j).getName());
             	}
             }
         } catch (JAXBException e) 
         {
             e.printStackTrace();
         }
         Transformer<String, String> transformer = new Transformer<String, String>() {

             public String transform(String arg0) {
             return arg0.toString();
             }

         };
         Layout<String, String> layout3 = new TreeLayout((Forest<String, String>) g);
         VisualizationViewer<String, String> vv3 = new  VisualizationViewer<String,String>(layout3);
        
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
         final DefaultModalGraphMouse<String,Number> graphMouse3 = new DefaultModalGraphMouse<String,Number>();
         vv3.setGraphMouse(graphMouse3);
      graphMouse3.setMode(Mode.PICKING);
      final PickedState<String> pickedState = vv3.getPickedVertexState();

   // Attach the listener that will print when the vertices selection changes.
   pickedState.addItemListener(new ItemListener() {
 	
 	public void itemStateChanged(ItemEvent e) {
 		// TODO Auto-generated method stub
 	    Object subject = e.getItem();
         // The graph uses Integers for vertices.
         if (subject instanceof String) {
             String vertex = (String) subject;
             if (pickedState.isPicked(vertex)) {
                 System.out.println("Vertex " + vertex
                     + " is now selected");
                 Monitor monitor=new Monitor();
	                s=monitor.Editt(vertex, selected);
	                } else {
                 System.out.println("Vertex " + vertex
                     + " no longer selected");
             }
         }
 	}
 });
        
   
  // frame3.setVisible(true);
   frame3 = new JFrame("Pas 3");
   frame3.getContentPane().add(vv3);	
    	
    	
    	
        final SwingNode swingNode = new SwingNode();

        createSwingContent(swingNode);
StackPane pane=new StackPane();
        stage.setTitle("Swing in JavaFX");
        stage.setScene(new Scene(pane, 250, 150));
        stage.show();
        }

    private void createSwingContent(final SwingNode swingNode) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	
            	   frame3.pack();
            	   frame3.setSize(350, 300);
				frame3.setVisible(true);
            }
        });
    }
    public static void main(String args[]) {
		launch(args);
	}
}
