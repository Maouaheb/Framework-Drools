package CoreApplication;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import UnmarshallingPhase.*;
import javax.swing.JFrame;
import org.apache.commons.collections15.Transformer;

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
 
public class JaxbExample
{
    public static void main(String[] args) 
    {
        String fileName = "C:/Users/belarbim/WeatherForecastEclipse/framework-rules/src/main/java/GeneratedFiles/hellopizza.xml";

 
        jaxbXmlFileToObject(fileName);
    }
 
    private static void jaxbXmlFileToObject(String fileName) {
       // Stage stage=new Stage();
       
		// Setting size for the pane

		// Setting the padding
    	 Graph<String, String> g = new DelegateForest<String, String>();
   
      
      
		
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
            } else {
                System.out.println("Vertex " + vertex
                    + " no longer selected");
            }
        }
	}
});
        JFrame frame3 = new JFrame("Pas 3");
        frame3.getContentPane().add(vv3);
        frame3.pack();
        frame3.setSize(350, 300);
        frame3.setVisible(true);
       
    }
}