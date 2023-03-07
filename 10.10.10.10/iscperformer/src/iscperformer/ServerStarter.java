/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//Code to Receive data
package iscperformer;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class ServerStarter extends Thread
{

   public long start;
   public long end;
   int x=0;
     public void run()
    {
        // System.out.println("Server Stated");
         try {
            // TODO add your handling code here:
            ServerSocket s = new ServerSocket(1254);
            while (true)
            {
              
                Socket s1 = s.accept();
                InputStream s1In = (InputStream) s1.getInputStream();  //data in bits
                DataInputStream dis = new DataInputStream(s1In); //data in bits converted to strings
                //String st = new String(dis.readUTF());
                String st = dis.readUTF();
                  // System.out.println("Communication Parameter is "+st);
             // System.out.println(st);
               if(st.contains("@"))
               {
                  // System.out.println(st);
                   ServerScreen.data.add(st); 
                    int req=ServerScreen.data.size();
                    end=System.currentTimeMillis();
                    long total=end-start;
                    System.out.println("Total Number of Requests are "+req);
                    System.out.println("Total Time is  "+total);
                     ServerScreen.data.clear();


                    
                    
                   
               }
                else if(st.contains("&"))
                {
//                   // System.out.println(st);
//                    x++;
//                    if(x==1)
//                    {
                     start=System.currentTimeMillis();
//                    }
                     ServerScreen.data.add(st); 
                }
 else
               {
                    ServerScreen.data.add(st);

              }

            

             }
        }
            catch(Exception e)
         {
                
            }
    }
}
