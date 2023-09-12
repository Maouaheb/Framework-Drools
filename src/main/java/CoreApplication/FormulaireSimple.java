package CoreApplication;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class FormulaireSimple  {

public FormulaireSimple(){
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));
		Stage stage=new Stage();
		Scene scene = new Scene(grid, 600, 600);
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
		Label adress=new Label("the adress for delivery");
		grid.add(adress, 0, 3);
		Label rue=new Label("Street");
		TextField ruetext=new TextField();
		grid.add(rue, 0, 4);
		grid.add(ruetext, 1, 4);
		Label num=new Label("Boite Num");
		TextField numtext=new TextField();
		grid.add(num, 2, 4);
		grid.add(numtext, 3, 4);
		Label codepostal=new Label("Code postal");
		TextField code=new TextField();
		Label ville=new Label("Ville");
		TextField villetext=new TextField();
		grid.add(ville, 0, 5);
		grid.add(villetext, 1, 5);
		stage.show();
	}
	
}
