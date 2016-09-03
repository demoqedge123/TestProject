import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class sqldbtest 
{


	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException 
	{
		
		String dburl,uid,pwd;
		dburl="jdbc:sqlserver://projects.qedgetech.com:1433;database=bankdb";
		uid="test";
		pwd="qedge@123";
		int brid;
		String brname;
		
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
		Connection dbcon;
		dbcon=DriverManager.getConnection(dburl, uid, pwd);
		
		Statement stmt=dbcon.createStatement();
		ResultSet rs=stmt.executeQuery("select branchid,branchname from " +
											"bankbranches order by branchid");
		
		while (rs.next()) 
		{
			brid=rs.getInt(1);
			brname=rs.getString("branchname");
			System.out.println(brid+"-"+brname);
		}
		rs.close();
		dbcon.close();
		

	}

}
