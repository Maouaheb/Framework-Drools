package FrameworkJavaFx;

import java.awt.Checkbox;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JFrame;

import java.util.Set;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javassist.CannotCompileException;
import javassist.NotFoundException;

public class Planner extends JFrame {
	public ArrayList<RadioButton> tactic=new ArrayList<RadioButton>();
	public HashMap<String, String>chosen=new HashMap<String,String>();
	Button execute=new Button("Execute plan ");
	public HashMap<String, ArrayList<RadioButton>>planed=new HashMap<String, ArrayList<RadioButton>>();
	public void View(SelectedTactiqueForFeature selected) {
		Stage stage = new Stage();
		stage.setTitle("Plan");
		Label feature=new Label("Feature");
		Label useful=new Label("Useful tactiques");
		GridPane pane=new GridPane();
		pane.add(feature, 0, 0);
		pane.add(useful, 1, 0);
		Iterator<Entry<String, ArrayList<String>>> it = selected.getTactiquefeature().entrySet().iterator();
		int ligne=1;
		while (it.hasNext()) {
			int colonne=0;
			Map.Entry<String, ArrayList<String>> m = it.next();
			String key = m.getKey().toString();
			Label featurename=new Label();
			featurename.setText(key);
			pane.add(featurename,colonne,ligne);
			ArrayList<String> value = m.getValue();
			ArrayList<RadioButton>b=new ArrayList<RadioButton>();
			for(int i=0;i<value.size();i++) {
				colonne=colonne+1;
				RadioButton box=new RadioButton(value.get(i).toString());
				b.add(box);
				//listeoftactiques.put(key,box);
				tactic.add(box);
				pane.add(box, colonne, ligne);

			}
			planed.put(key, b);
			
			ligne=ligne+1;

		}
	
		pane.add(execute,0,ligne);
		// Root Item

		Scene scene = new Scene(pane, 800, 800);
		stage.setScene(scene);
		stage.show();
		execute.setOnAction(new EventHandler<ActionEvent>() {
			
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Iterator<Entry<String, ArrayList<RadioButton>>> it2 = planed.entrySet().iterator();
				while(it2.hasNext()) {
					Entry<String, ArrayList<RadioButton>> m=it2.next();
					String key=m.getKey();
				
					//System.out.println("tactique   "+m.getValue().getText()+" for "+key);
					for(int i=0;i<m.getValue().size();i++) {
						if(m.getValue().get(i).isSelected()==true) {
							String v=m.getValue().get(i).getText();
							chosen.put(key, v);
							System.out.println("is selected true tactique   "+v+" for "+key);

						}	
					}
				
					
				}
				try {
					new Executor(chosen);
				} catch (NotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (CannotCompileException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

	}

}
