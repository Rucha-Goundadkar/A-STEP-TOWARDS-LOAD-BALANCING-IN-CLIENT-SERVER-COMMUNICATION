/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package requestgeneratorengin;
import java.sql.*;
 public class UpdateInfo
 	{
	public boolean update(String sid,String sip)
{
try
{
	  Class.forName("com.mysql.jdbc.Driver").newInstance();
 	  Connection Conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/requestengin","root","root");
 	  Statement stmt = Conn.createStatement();
          String str="Update serverinfo set s_ip='"+sip+"' where sid='"+sid+"'";

  	   	 int x=stmt.executeUpdate(str);
 	  	if(x>0)
 	  	{
 	  		return true;
 	  	}
 	  	else
 	  	{
 	  		return false;
 	  	}

  	}
 	 	catch(Exception e)
 	{
 		System.out.println(e);
 		return false;
 	}

}

}