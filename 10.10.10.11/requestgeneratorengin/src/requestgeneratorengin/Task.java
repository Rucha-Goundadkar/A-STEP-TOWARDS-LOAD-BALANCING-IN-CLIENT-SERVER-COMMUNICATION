
package requestgeneratorengin;


import java.util.ArrayList;
import java.util.TimerTask;

public class Task extends TimerTask
{

   public  static ArrayList temp=new ArrayList();
    int i=-1;
   
    
    public void run()
    {
        int count=temp.size();



     //   System.out.println("Temp size is "+temp.size());

 i++;
      if(i<count)
       {
        String  t=(String)temp.get(i);
        //  System.out.println("TTT is "+t);
          RequestSender1  rs1=new RequestSender1();
                rs1.sender("start");
              ServerHandler  sh=new ServerHandler();
          sh.setData(t);

         sh.start();
        }

      

        

       }


   

}
