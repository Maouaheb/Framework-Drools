package FrameworkJavaFx;

import java.awt.Checkbox;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import javax.swing.JFrame;

import org.drools.compiler.compiler.DroolsParserException;
import org.drools.compiler.compiler.PackageBuilder;
import org.drools.core.RuleBase;
import org.drools.core.RuleBaseFactory;
import org.drools.core.WorkingMemory;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Monitor extends JFrame {
	MenuButton bindingchoix;
	private String binding;
	tactiqueProperties t;
	Analyzer p;
	MenuButton granularitychoix;
	MenuButton evolutionchoix;
	Boolean treated;
GridPane grid;
	public boolean Editt(final String nameFeature, final SelectedTactiqueForFeature selected) {
		 grid = new GridPane();
		treated = false;
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));
		Stage stage = new Stage();
		Scene scene = new Scene(grid, 600, 600);
		stage.setTitle(nameFeature);
		stage.setScene(scene);
		Button submit = new Button("Submit");
		Text scenetitle = new Text("Variability characteristics");
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));

		/* check box */
		Label typefeature = new Label("Type of feature ");
		grid.add(typefeature, 0, 1);
		CheckBox interne = new CheckBox("Interne");
		CheckBox client = new CheckBox("Business");
		CheckBox user = new CheckBox("User");
		CheckBox autre = new CheckBox("Other");
		grid.add(interne, 1, 1);
		grid.add(client, 2, 1);
		grid.add(user, 3, 1);
		grid.add(autre, 4, 1);
		/* Binding time */
		Label bindingtime = new Label("Binding time");
		final MenuItem compiletime = new MenuItem("Compile-time");
		final MenuItem runtime = new MenuItem("Run-time");
		final MenuItem designtime = new MenuItem("Design-time");
		final MenuItem installtime = new MenuItem("install-time");
		bindingchoix = new MenuButton("select");
		bindingchoix.getItems().addAll(designtime, runtime, compiletime, installtime);
		p = new Analyzer();

		// select type of features
		interne.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				compiletime.setDisable(true);
				runtime.setDisable(true);
				TextField bd=new TextField();
				TextField root=new TextField();
				TextField pwd=new TextField();
				TextField port=new TextField();
				bd.setPromptText("name of db");
				root.setPromptText("username of db");
				pwd.setPromptText("password of db");
				port.setPromptText("port of db");
				grid.add(bd, 9,1 );
				grid.add(root, 9,2 );
				grid.add(pwd, 9,3 );
				grid.add(port, 9,4 );
				
			}
		});
		user.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				installtime.setDisable(true);
				designtime.setDisable(true);
			}
		});
		client.setOnAction(new EventHandler<ActionEvent>() {
			
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				installtime.setDisable(true);
			}
		});
		// select binding time
		compiletime.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				bindingchoix.setText(compiletime.getText());

				p.setBindingtime(compiletime.getText());
				// p.bindingtime(compiletime.getText(), nameFeature, selected);

			}
		});
		runtime.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub

				System.out.println("run time is selected !!");
				bindingchoix.setText(runtime.getText());
				p.setBindingtime(runtime.getText());
				// p.bindingtime(runtime.getText(), nameFeature, selected);

			}
		});
		designtime.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub

				System.out.println("design time is selected !!");
				bindingchoix.setText(designtime.getText());

			}
		});
		grid.add(bindingtime, 0, 2);
		grid.add(bindingchoix, 1, 2);

		bindingchoix.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				bindingchoix.setText(((MenuItem) arg0.getSource()).getText() + " selected from edit class");

			}
		});
		installtime.setOnAction(new EventHandler<ActionEvent>() {
			
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				p.setBindingtime(installtime.getText());
				

			}
		});

		/* Granularity */
		Label granularity = new Label("Granularity");
		final MenuItem fine = new MenuItem("Fine");
		final MenuItem coarse = new MenuItem("Coarse");
		final MenuItem medium = new MenuItem("Medium");
		final MenuItem any = new MenuItem("Any");
		granularitychoix = new MenuButton("Options", null, fine, medium, coarse, any);
		fine.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				granularitychoix.setText(fine.getText());
				p.setGranularity(fine.getText());

			}
		});
		coarse.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				granularitychoix.setText(coarse.getText());
				p.setGranularity(coarse.getText());

			}
		});
		medium.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				granularitychoix.setText(medium.getText());
				p.setGranularity(medium.getText());

			}
		});
		any.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				granularitychoix.setText(any.getText());
				p.setGranularity(any.getText());
			}
		});
		grid.add(granularity, 0, 3);
		grid.add(granularitychoix, 1, 3);
		/* Evolution */
		Label evolution = new Label("Evolution");
		final MenuItem open = new MenuItem("Open");
		final MenuItem close = new MenuItem("Close");
		evolutionchoix = new MenuButton("Options", null, open, close);
		grid.add(evolution, 0, 4);
		grid.add(evolutionchoix, 1, 4);
		open.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				evolutionchoix.setText(open.getText());
				p.setEvolution(open.getText());
			}
		});
		close.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				evolutionchoix.setText(close.getText());
				p.setEvolution(close.getText());
			}
		});
		/* Quality Creteria */
		Label quality = new Label("Quality Criteria");
		MenuItem soc = new MenuItem("Seperation of Concerns");
		MenuItem fd = new MenuItem("Feature dependency");
		MenuItem cross = new MenuItem("Crosscutting");
		MenuButton qualitychoix = new MenuButton("Options", null, soc, fd, cross);
		grid.add(quality, 0, 5);
		grid.add(qualitychoix, 1, 5);
		grid.add(submit, 0, 6);
		submit.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				setVisible(false);
				p.bindingtime(p.getBindingtime(), p.getGranularity(), p.getEvolution(), nameFeature, selected);
				treated = true;
			}
		});
		stage.show();
		return treated;

	}

}
