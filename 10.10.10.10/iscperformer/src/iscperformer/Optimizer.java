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


public class Optimizer extends Thread
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

                if(st.equals("start"))
                {
              ServerScreen.status=true;

              System.out.println("Set to true >>>>>>>>>>>>");

                }
                else if(st.contains("@"))
               {
//                  if(ServerScreen.status==false)
                  {
                     // ServerScreen.data.add(st);
                     st=st.replace("@", "");
                   ServerScreen.data.add(st);
                    int req=ServerScreen.data.size();
                    try
                    {

                        Thread.sleep(5);
                    }
                    catch(Exception e){ }


                    end=System.currentTimeMillis();
                    long total=end-start;
                    if(req>20)
                    {

                        System.out.println("ALERT ! ALERT ! TRYING TO PERFORM DOS ATTACK");
                    }
                    System.out.println("Total Number of Requests are "+req);
                    System.out.println("Total Time is  "+total);

                   // if(!st.contains("*"))
                   {

                        if(req<=20)
                        {
                    for(int i=0;i<ServerScreen.data.size();i++)
                    {



                        String sr=(String)ServerScreen.data.get(i);
                        sr=sr.replace("@", "");
                        sr="S10 : "+ sr;
                        ServerScreen.master.add(sr);


                    }
                       }

 else
                        {

                            for(int i=0;i<20;i++)
                    {



                        String sr=(String)ServerScreen.data.get(i);
                        sr=sr.replace("@", "");
                         sr="S10 : "+ sr;
                        ServerScreen.master.add(sr);


                    }


                          }
                     ServerScreen.data.clear();

                  // System.out.println(st);
                 
                    try
                    {

                    Optimizer.sleep(1000);
                    }
                    catch(Exception e)
                    {
                       System.out.println("Exception at sleep of OS "+e);
                    }

                     if(ServerScreen.status==true)
                     {
                   ISCServer01  ic1=new ISCServer01();
                   ic1.sender("isc");


                   ISCServer02  ic2=new ISCServer02();
                   ic2.sender("isc");
                   ServerScreen.status=false;
                       }


                }
                    
                     //ServerScreen.data.clear();
//                     ServerScreen.status=true;

                }
                    
                    ServerScreen.data.clear();
                   
               }
                else if(st.contains("&"))
                {

                         st=st.replace("&", "");
//                         if(st.contains("%"))
//                         {
//                             ServerScreen.status=false;
//                             System.out.println("Set status ++++++++++++++");
//                         }
                     ServerScreen.data.add(st); 
                }
 else if(!st.contains("isc"))
               {
                       // st=st.replace("@", "");
                    ServerScreen.data.add(st);

              }
 else if (st.contains("optimization"))
                {

     System.out.println("Opt is "+st);

                 }

                if(st.contains("isc"))
                {


                    st=st.replace("isc","");

                    ServerScreen.master.add(st);

                 //  System.out.println("MMM is "+st);
                   if(st.contains("end"))
                   {
                       st=st.replace("end", "");



                     //  ArrayList mas=new ArrayList();
                       System.out.println("Master Size is >>>>>>>>>>>>> "+ServerScreen.master.size());
                       int tot=ServerScreen.master.size();
                          int f1=tot/3;
                          int r=tot-f1;
                         int f2=r/2;
                        int f3=tot-(f1+f2);

                         int t1=f1;
                        int t2=f1+f2;
                        int t3=f1+f2+f3;


                        System.out.println("T1 = "+t1 +"\n "+"T2 = "+t2+"\n"+"T3 = "+t3);
                       
                        // Optimization starts ++++++++++++++++++++++++++++++++++++++=
                       
//                       for(int i=0;i< ServerScreen.master.size();i++)
//                       {
//
//                            String srr=(String)ServerScreen.master.get(i);
//                          //  System.out.println("master is "+srr);
//
//
//
//                       }

                        for(int k=0;k<10;k++)
                        {
                             try
                    {

                    Optimizer.sleep(300);
                    }
                    catch(Exception e)
                    {
                       System.out.println("Exception at sleep of OS "+e);
                    }


                        }

                          try
                    {

                    Optimizer.sleep(3000);
                    }
                    catch(Exception e)
                    {
                       System.out.println("Exception at sleep of OS "+e);
                    }


      for(int i=0;i<t1;i++)
      {
           String st12=(String)ServerScreen.master.get(i);
              if(i==0)
           {

               st12=st12+"start";
           }

           if(i==(t1-1))
           {

               st12=st12+"close";
           }
 st12=st12+"optimization";
 ServerScreen.opdata.add(st12);
          // System.out.println("ST AT RS "+st12);
             //  RequestSender1  rs1=new RequestSender1();
              //  rs1.sender(st12);

      }

         for(int i=t1;i<t2;i++)
      {
           String st12=(String)ServerScreen.master.get(i);
            if(i==t1)
           {

               st12=st12+"start";
           }
            if(i==(t2-1))
           {

               st12=st12+"close";
           }
           st12=st12+"optimization";
               RequestSender2  rs2=new RequestSender2();
                rs2.sender(st12);

      }
//
         for(int i=t2;i<t3;i++)
      {
          String st12=(String)ServerScreen.master.get(i);
            if(i==t2)
           {

               st12=st12+"start";
           }
            if(i==(t3-1))
           {

               st12=st12+"close";
           }
             st12=st12+"optimization";
               RequestSender3  rs3=new RequestSender3();
                rs3.sender(st12);

      }




                        //Optimaization ends +++++++++++++++++++++++++++++++++++++++++++++++++

                        for(int i=0;i<ServerScreen.opdata.size();i++)
                        {

                            String str=(String)ServerScreen.opdata.get(i);
                            System.out.println("op data is "+str);
                        }
                        



                        ServerScreen.master.clear();
                        ServerScreen.opdata.clear();


                   }
                }

                
            

             }
        }
            catch(Exception e)
         {

                System.out.println("Exception at main OS "+e);
                
            }
    }
}
