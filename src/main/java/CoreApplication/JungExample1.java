package CoreApplication;

import java.awt.Dimension;

import javax.swing.JFrame;
import org.apache.commons.collections15.Transformer;

import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.algorithms.layout.TreeLayout;
import edu.uci.ics.jung.graph.DelegateForest;
import edu.uci.ics.jung.graph.Forest;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.visualization.VisualizationViewer;
import edu.uci.ics.jung.visualization.control.DefaultModalGraphMouse;
import edu.uci.ics.jung.visualization.control.ModalGraphMouse.Mode;

/**
 * First JUNG example:
 * Three vertices and three directed vertices connecting the edges.
 * 
 * @author Arieh 'Vainolo' Bibliowicz
 * 
 */
public class JungExample1 {
  public static void main(String[] args) {
	  Graph<String, String> g = new DelegateForest<String, String>();
	  g.addVertex("1");
      g.addVertex("2");
      g.addVertex("3");

      g.addEdge("RAD-A", "1", "2");
      g.addEdge("RAD-B","1", "3");
    Transformer<String, String> transformer = new Transformer<String, String>() {

        public String transform(String arg0) {
        return arg0.toString();
        }

    };
    Layout<String, String> layout3 = new TreeLayout((Forest<String, String>) g);
    VisualizationViewer<String, String> vv3 = new  VisualizationViewer<String,String>(layout3);

    vv3.getRenderContext().setVertexLabelTransformer(transformer);
  
    final DefaultModalGraphMouse<String,Number> graphMouse3 = new DefaultModalGraphMouse<String,Number>();
    vv3.setGraphMouse(graphMouse3);
 graphMouse3.setMode(Mode.PICKING);

    JFrame frame3 = new JFrame("Pas 3");
    frame3.getContentPane().add(vv3);
    frame3.pack();
    frame3.setSize(350, 300);
    frame3.setVisible(true);
  }
}
