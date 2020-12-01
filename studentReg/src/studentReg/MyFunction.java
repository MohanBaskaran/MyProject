package studentReg;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class MyFunction {

	public static int countData(String tableName) 
	{
		int total=0;
		Connection con= MyConnector.getConnection();
		try {
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("SELECT COUNT(*) AS 'total' FROM "+ tableName);
			while (rs.next()) {
				total=rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		
		return total;
	}
}
