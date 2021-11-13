import java.sql.*;

public class OracleHandler extends PersistenceHandler {
	
		
	public OracleHandler()
	{
		
	}
	
	@Override
	public void Save(SavingsAccount saccount, CheckingAccount caccount)
	{
		try
		{
			Class.forName("oracle.jdbc..driver.OracleDriver");
			System.out.println("Driver Loaded ");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@172.16.39.40:1521:xe","system","tiger12345");
			System.out.println("Connection Established ");
			
			String sql = "Insert into Savings Account (?,?,?,?)";
			PreparedStatement statement = con.prepareStatement(sql);
			String [] accno = saccount.getAccountNo();
			String [] name = saccount.getSavingsName();
			String [] address = saccount.getSavingsAddress();
			String [] phone = saccount.getSavingsPhoneno();
			
			Array Array1 = con.createArrayOf("AccountNo", accno);
			Array Array2 = con.createArrayOf("Name", name);
			Array Array3 = con.createArrayOf("Address", address);
			Array Array4 = con.createArrayOf("Phone", phone);
			
			statement.setArray(0, Array1);
			statement.setArray(1, Array2);
			statement.setArray(2, Array3);
			statement.setArray(3, Array4);
			
			
			String sql1 = "Insert into Checkings Account (?,?,?,?)";
			PreparedStatement statement1 = con.prepareStatement(sql);
			String [] accno1 = caccount.getAccountNo();
			String [] name1 = caccount.getCheckingName();
			String [] address1 = caccount.getCheckingAddress();
			String [] phone1 = caccount.getCheckingPhoneno();
			
			Array Array11 = con.createArrayOf("AccountNo", accno1);
			Array Array22 = con.createArrayOf("Name", name1);
			Array Array33 = con.createArrayOf("Address", address1);
			Array Array44 = con.createArrayOf("Phone", phone1);
			
			statement.setArray(0, Array11);
			statement.setArray(1, Array22);
			statement.setArray(2, Array33);
			statement.setArray(3, Array44);
			
			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("Data Saved");
			}
			else {
				System.out.println("Data NOT Saved");
			}
			con.close();
			
		} catch (ClassNotFoundException e) 
		{
			System.out.println("Driver not Loaded");
		}
		catch (SQLException e)
		{
			System.out.println("Connection not Established");
			e.printStackTrace();
		}
	}
}
