/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package requestgeneratorengin;
import java.sql.*;
import java.util.*;

 public class DetailFetcher
 		{

    public String s1;//id
    public String s2;//ip add
	public ArrayList getInformation()
	{

       ArrayList m1=new ArrayList();

		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
 			Connection Conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/requestengin","root","root");
 			Statement stmt = Conn.createStatement();

 			String quer=("SELECT * FROM serverinfo");
 			System.out.println ("==========quer============"+quer);
			ResultSet rs = stmt.executeQuery(quer);

			while(rs.next())
			{

//sid, s_ip
                            ArrayList m=new ArrayList();

			s1=rs.getString("sid");
                        s2=rs.getString("s_ip");
     

                     m.add(s1);
                      m.add(s2);

                      m1.add(m);
		}
            }
			catch(Exception e)
			{
				System.out.println("Exception ="+e);
			}



			return m1;

	}
 }