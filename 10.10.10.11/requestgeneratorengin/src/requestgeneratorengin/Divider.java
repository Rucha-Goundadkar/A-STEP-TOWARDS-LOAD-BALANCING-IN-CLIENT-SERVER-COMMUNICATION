
package requestgeneratorengin;

import java.util.ArrayList;


public class Divider

{
    public static ArrayList master=new ArrayList();
public ArrayList divideData(ArrayList data,int k)
    {

System.out.println("Size is  :: "+k);
     
int count =0;
 


String temp="";

     for( int i=0;i<data.size();i++)
     {
 

 
  String st=(String)data.get(i);
  temp=temp+st+"#";
 // td.add(st);
    count++;
      if(count==k)
      {
    master.add(temp);
    //System.out.println("While adding  "+td);
        count=0;
        //td.clear();
        temp="";
      }

     }

//System.out.println("mas size is  -----------------------  "+master.size());
//System.out.println("Mas ele are "+master);

System.out.println("master size ____________________________________ "+master.size());
for(int i=0;i<master.size();i++)
{

  //  String  m=(String)master.get(i);
  //  System.out.println("m is --  "+m);
}


return master;

}
}
