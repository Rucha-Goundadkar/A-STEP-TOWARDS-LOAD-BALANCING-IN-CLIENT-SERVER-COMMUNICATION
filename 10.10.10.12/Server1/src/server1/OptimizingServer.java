/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//Code to Receive data
package server1;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


public class OptimizingServer extends Thread
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
          //   System.out.println("St is  "+st);
               if(st.contains("@"))
               {
                  // System.out.println(st);
                   ServerScreen.data.add(st); 
                    int req=ServerScreen.data.size();

                    try
                    {
                        Thread.sleep(5);
                    }
                    catch(Exception e)
                    {
                        
                    }
                    end=System.currentTimeMillis();
                    long total=end-start;
                    if(req>20)
                    {

                        System.out.println("ALERT ! ALERT ! TRYING TO PERFORM DOS ATTACK ....");
                    }
                    System.out.println("Total Number of Requests are "+req);
                    System.out.println("Total Time is  "+total);

//                    ServerScreentemp= ServerScreen.data;
                   // System.out.println("Temp is  "+temp);
                   // System.out.println("ss data is  "+ServerScreen.data);

                    if(req<=20)
                    {
                    for(int i=0;i<ServerScreen.data.size();i++)
                    {


                        String ff=(String)ServerScreen.data.get(i);
                        ff="S12 : "+ff;
                        ServerScreen.temp.add(ff);
                      //  System.out.println("ff "+ff);
                    }
                   }
 else
                    {
                         for(int i=0;i<20;i++)
                    {


                        String ff=(String)ServerScreen.data.get(i);
                         ff="S12 : "+ff;
                        ServerScreen.temp.add(ff);
                      //  System.out.println("ff "+ff);
                    }


                      }
                     ServerScreen.data.clear();


                    
                    
                   
               }
                else if(st.contains("&"))
                {

                     start=System.currentTimeMillis();

                     ServerScreen.data.add(st); 
                }
 else if(!st.contains("isc") && (!st.contains("optimization")))
               {
                    ServerScreen.data.add(st);

              }
 else if(st.contains("optimization"))
               {

     System.out.println("OP is "+st);
                }




                  if(st.equals("isc"))
                  {
                    try
                    {

                     Thread.sleep(1000);
                    }
                    catch(Exception e)
                    {

                    }
//System.out.println("st is  "+st);

                  

                  for(int i=0;i<ServerScreen.temp.size();i++)
                    {


                        String ff=(String)ServerScreen.temp.get(i);
                        ff=ff.replace("@", "");
                        ff=ff.replace("&","");
                         ff=ff+"isc";
                       // System.out.println("ff "+ff);
                        ISCResponse  irt=new ISCResponse();
                        irt.sender(ff);


                    }

                   ServerScreen.temp.clear();
                    




                      
                  }
            

             }
        }
            catch(Exception e)
         {
                
            }
    }
}
