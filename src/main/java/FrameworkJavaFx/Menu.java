package FrameworkJavaFx;

import java.lang.reflect.InvocationTargetException;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TreeTableView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Menu extends Application {
	public RadioButton rb2;
	public RadioButton rb3;
	public Boolean w,s,g;
	public SelectedTactiqueForFeature selected;

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		selected = new SelectedTactiqueForFeature();
		rb2 = new RadioButton();
		rb3 = new RadioButton();
		Button editw = new Button("Edit");
		Button editf = new Button("Edit");
		rb2.setText("Welcome");
		Label formsimple=new Label("Formulaire Simple");
		Label formgps=new Label("Formulaire GPS");

		rb3.setText("Formulaire");
		GridPane gridPane = new GridPane();
		// Setting size for the pane
		gridPane.setMinSize(500, 500);

		// Setting the padding
		gridPane.setPadding(new Insets(10, 10, 10, 10));

		// Setting the vertical and horizontal gaps between the columns
		gridPane.setVgap(5);
		gridPane.setHgap(5);
		Text text = new Text("configure the variant ");
		gridPane.add(text, 0, 1);
		gridPane.add(rb2, 0, 2);
		gridPane.add(editw, 1, 2);
		gridPane.add(rb3, 0, 3);
		gridPane.add(editf, 1, 3);
		gridPane.add(formgps, 0, 4);
		gridPane.add(formsimple, 0, 5);
		Scene scene = new Scene(gridPane);
		stage.setScene(scene);
		gridPane.setAlignment(Pos.CENTER);
		Button analysis = new Button("Analysis phase !");
		gridPane.add(analysis, 0, 6);

		
		editf.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Monitor e=new Monitor();
				s=e.Editt(rb3.getText(),selected);

			}
		});
		editw.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Monitor e=new Monitor();
				w=e.Editt(rb2.getText(),selected);

			}
		});
analysis.setOnAction(new EventHandler<ActionEvent>() {
			
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
					Planner view=new Planner();
					view.View(selected);
				
			}
		});
		stage.show();

	}

	public static void main(String args[]) {
		launch(args);
	}
}
