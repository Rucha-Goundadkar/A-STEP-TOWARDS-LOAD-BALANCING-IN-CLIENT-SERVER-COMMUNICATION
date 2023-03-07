/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package requestgeneratorengin;

import java.util.ArrayList;


public class ServerHandler extends Thread
{
   public String temp;
String str="";
    public void run()
    {

        String str[]=temp.split("#");
      //  System.out.println("Total Data count is  "+str.length);



        int tot=str.length;

        CurrentParam   cp=new CurrentParam();
        String p=cp.getDate();

       
        long t=Long.parseLong(p);
        int s1=(int) (t % 3);
         //System.out.println("srrr :"+s1);

    

      long sum=0;

        while(t>0)
        {
            long d= (t % 10);

            sum=sum+d;
            t=t/10;



        }

     // System.out.println("Sum is ===================================="+sum);

      int t1 = 0,t2 = 0,t3 = 0;

    if(s1==1)
        {
     t1=tot/2;
     int r=tot-t1;
      t2=r/2;
       t3=tot-(t1+t2);

      System.out.println("k1= "+t1);
       System.out.println("k2= "+t2);
       System.out.println("k3= "+t3);

        }
 else   if(s1==2)
        {
   t1=tot/4;
     int r=tot-t1;
      t2=r/3;
      t3=tot-(t1+t2);

      System.out.println("k1= "+t1);
       System.out.println("k2= "+t2);
       System.out.println("k3= "+t3);





        }
 else   if(s1==0)
        {
//            System.out.println("s2 : "+s1);


      t1=tot/3;
     int r=tot-t1;
     t2=r/2;
      t3=tot-(t1+t2);

      System.out.println("k1= "+t1);
       System.out.println("k2= "+t2);
       System.out.println("k3= "+t3);



        }

       

      
       int f1=t1;
       int f2=t1+t2;
       int f3=t1+t2+t3;



      for(int i=0;i<f1;i++)
      {
           String st=str[i];
              if(i==0)
           {

               st=st+"&";
           }

           if(i==(f1-1))
           {

               st=st+"@";
           }
               RequestSender1  rs1=new RequestSender1();
                rs1.sender(st);

      }

         for(int i=f1;i<f2;i++)
      {
           String st=str[i];
            if(i==f1)
           {

               st=st+"&";
           }
            if(i==(f2-1))
           {

               st=st+"@";
           }
               RequestSender2  rs2=new RequestSender2();
                rs2.sender(st);

      }

         for(int i=f2;i<f3;i++)
      {
           String st=str[i];
            if(i==f2)
           {

               st=st+"&";
           }
            if(i==(f3-1))
           {

               st=st+"@";
           }
               RequestSender3  rs3=new RequestSender3();
                rs3.sender(st);

      }



//
//        for(int i=0;i<str.length;i++)
//        {
//
//            String st=str[i];
//            System.out.println("ST IS  "+st);
//
//
//
//
//              RequestSender1  rs=new RequestSender1();
//            rs.sender(st);
//
//
//
//
//
//
//            RequestSender2  rs2=new RequestSender2();
//            rs2.sender(st);
//
//        }



    }

    public void setData(String mas)
    {
        temp=mas;
    }
}
