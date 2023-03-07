/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package requestgeneratorengin;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import jxl.*; /* Import declarations to the JExcel JAR file */
import jxl.write.*; /* Import declarations to the JExcel JAR file */
public class NetworkDataReader /* The name of our class file */
{
    public ArrayList readPacektData(String sf)
    {
         ArrayList m=new ArrayList();  
        try
        {
            Workbook ReadExcel = Workbook.getWorkbook(new File(sf));
            Sheet sheet = ReadExcel.getSheet(0);
            int a=sheet.getColumns();
            int b=sheet.getRows();
            System.out.println(Integer.toString(a));
            System.out.println(Integer.toString(b));
            for (int i=1;i<b;i++)//Loop for rows
            {
               // ArrayList in=new ArrayList();
                String str="";
                for(int j=0;j<a;j++)//Loop for columns
                {
                Cell a1 = sheet.getCell(j,i); /* Get the first cell of Column A , 0 maps to A */
                String ed = a1.getContents();
               // System.out.print(ed+"    ");
                str=str+ed+",";
                //in.add(ed);
                }
                m.add(str);
              //  System.out.println("");
            }
            ReadExcel.close();
        }
        catch (Exception i)
        {
           // System.out.println(i);
        }
 return m;
    }
}