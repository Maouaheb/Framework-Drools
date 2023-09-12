package GeneratedFiles;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javafx.scene.control.Label;

public class PrototypeConnexion {
	public boolean getConnection(String userName, String password) {
		boolean result=false;
		boolean colorblind=false;
		try {
			Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/swing_demo",
					"root", "root");

			PreparedStatement st = (PreparedStatement) connection
					.prepareStatement("Select id, name, password, handicap from student where name=? and password=?");
			st.setString(1, userName);
			st.setString(2, password);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				String name = rs.getString(2);
				String p = rs.getString(3);
				String h = rs.getString("handicap");
				int idUser = rs.getInt(1);
				//User user = new User();
				result= true;
				
			} else {
				
				result= false;

			}

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
		return result;
	}

	public void addUser(String userName, String password, String handicap, Label lblMessage) {

		try {
			Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/swing_demo",
					"root", "root");

			PreparedStatement st = (PreparedStatement) connection
					.prepareStatement("insert into student (name, password,handicap) values (?, ?, ?)");

			st.setString(1, userName);
			st.setString(2, password);
			st.setString(3, handicap);
			st.executeUpdate();
			
				

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
		
	}
	public ArrayList<Object> getProducts(String type) {
			Connection connection;
			ArrayList<Object>products=new ArrayList<Object>();
			try {
				connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/swing_demo",
						"root", "root");
				PreparedStatement st = (PreparedStatement) connection
						.prepareStatement("Select id, name, type, brand, price, quantity, image from items where type=?");
				st.setString(1, type);
				ResultSet rs = st.executeQuery();
				if (rs.next()) {
					String name = rs.getString(2);
					String t = rs.getString(3);
					String brand = rs.getString(4);
					int id = rs.getInt(1);
					float price=rs.getFloat(5);
					int quantity=rs.getInt(6);
					String image=rs.getString(7);
			} }catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		
			
		return products;
	}
	
	public ArrayList<Object> getProductsMotCles(String name) {
		Connection connection;
		ArrayList<Object>products=new ArrayList<Object>();
		try {
			connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/swing_demo",
					"root", "root");
			PreparedStatement st = (PreparedStatement) connection
					.prepareStatement("Select id, type, brand, price, quantity, image from items where name=?");
			st.setString(1, name);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				String type = rs.getString(2);
				String brand = rs.getString(3);
				int id = rs.getInt(1);
				float price=rs.getFloat(4);
				int quantity=rs.getInt(5);
				String image=rs.getString(6);
				
		} }catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
		
	return products;
}

	
	public void updateProduct(Object p) {
		Connection connection;
		try {
			connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/swing_demo",
					"root", "root");
			PreparedStatement st = (PreparedStatement) connection
					.prepareStatement("update items set quantity=? where id=?");
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

