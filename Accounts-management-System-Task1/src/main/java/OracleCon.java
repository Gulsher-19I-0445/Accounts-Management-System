import java.sql.*;
public class OracleCon {
	
	OracleCon(){
		
	}
	
	public void ToDataBase(Checking c) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver successfully loaded");
			
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
			System.out.println("Connection Established");
			
			String sql="INSERT INTO accounts(Acc_id,Name,Balance,Acc_typ,dt_created) VALUES (?,?,?,?,?)";
			PreparedStatement statement=con.prepareStatement(sql);
			statement.setString(1,c.getAccNum());
			statement.setString(2,c.getName());
			statement.setInt(3, c.getBalance());
			statement.setString(4, "Checking");
			statement.setString(5, c.getDate());
			statement.executeUpdate();
			//int i=statement.executeUpdate();
			//con.commit();
			//con.close();
			
			
		}
		catch(ClassNotFoundException e) {
			System.out.println("Driver not loaded");
		}
		
		catch(SQLException e) {
			System.out.println("Connection Failed");
		}
	}
	
	public void ToDataBase(Saving s) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver successfully loaded");
			
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
			System.out.println("Connection Established");
			
			String sql="INSERT INTO accounts(Acc_id,Name,Balance,Acc_typ,dt_created) VALUES (?,?,?,?,?)";
			PreparedStatement statement=con.prepareStatement(sql);
			statement.setString(1,s.getAccNum());
			statement.setString(2,s.getName());
			statement.setInt(3, s.getBalance());
			statement.setString(4, "Saving");
			statement.setString(5, s.getDate());
			statement.executeUpdate();
			//int i=statement.executeUpdate();
			//con.commit();
			//con.close();
			
			
		}
		catch(ClassNotFoundException e) {
			System.out.println("Driver not loaded");
		}
		
		catch(SQLException e) {
			System.out.println("Connection Failed");
		}
	}
	
	
	public void UpdateMyDbBalance(int balance,String MyID) throws SQLException, ClassNotFoundException {
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
		String sql="UPDATE accounts SET Balance =? WHERE Acc_id=?";
		PreparedStatement statement= con.prepareStatement(sql);
		statement.setString(2, MyID);
		statement.setInt(1, balance);
		statement.executeUpdate();
		}
		catch(ClassNotFoundException e) {
			System.out.println("Driver not loaded");
		}
		
		catch(SQLException e) {
			System.out.println("Connection Failed");
		}
		
	}

	/*public static void main(String args[]) throws SQLException {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver successfully loaded");
			
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
			System.out.println("Connection Established");
		}
		catch(ClassNotFoundException e) {
			System.out.println("Driver not loaded");
		}
		
		catch(SQLException e) {
			System.out.println("Connection Failed");
		}
		
	}*/
	

}
