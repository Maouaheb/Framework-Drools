package CoreApplication;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class FormulaireGPS {

	public FormulaireGPS() {
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));
		Stage stage=new Stage();
		Scene scene = new Scene(grid, 1000, 1000);
		stage.setScene(scene);		
		Text scenetitle = new Text("Pay my pizza");
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		grid.add(scenetitle, 0, 0, 2, 1);
		Label username=new Label("Name");
		TextField name=new TextField();
		grid.add(username, 0, 1);
		grid.add(name, 1, 1);
		Label numCard=new Label("#card");
		TextField numcard=new TextField();
		grid.add(numCard, 0, 2);
		grid.add(numcard, 1, 2);
		Label gps=new Label("GPS delivery");
		grid.add(gps, 0, 3);
		MyBrowser m=new MyBrowser();
		grid.add(m, 1, 3);
		Button pay=new Button("pay order");
		grid.add(pay, 0, 4);
		stage.show();
		
	}
	

}
