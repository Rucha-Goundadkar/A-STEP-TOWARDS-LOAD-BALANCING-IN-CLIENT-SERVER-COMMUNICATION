/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package requestgeneratorengin;




import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.io.*;
import java.util.*;




 public class CurrentParam
 {
	public String getDate()
	{

 Calendar cal = Calendar.getInstance();
  					// DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            DateFormat dateFormat = new SimpleDateFormat("ddMMyyyyhhmmss");


 				  String p=dateFormat.format(cal.getTime());
  				// System.out.println("Today's date is "+p);

 				  return p;

}

 }