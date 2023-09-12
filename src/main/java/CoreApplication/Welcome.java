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

public class Welcome  {

	public Welcome() {
		Stage stage=new Stage();
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));

		Scene scene = new Scene(grid, 400, 400);
		stage.setScene(scene);		
		Text scenetitle = new Text("My Bolo pizza in 1 click");
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		grid.add(scenetitle, 0, 0, 2, 1);

		Label quantity = new Label("Quantity");
		grid.add(quantity, 0, 1);
		TextField pizzaquantity = new TextField("1");
		grid.add(pizzaquantity, 1, 1);
		Button plusButton = new Button("+");
        Button minusButton = new Button("-");
        Button pay=new Button("Pay");
        
        grid.add(plusButton, 2, 1);
        grid.add(minusButton, 3, 1);
        grid.add(pay, 0, 2);

        stage.show();
	}
	

}
