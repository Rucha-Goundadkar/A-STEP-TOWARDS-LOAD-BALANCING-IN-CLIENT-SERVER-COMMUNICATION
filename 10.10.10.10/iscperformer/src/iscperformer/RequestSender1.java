/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package iscperformer;


import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;


public class RequestSender1
{
public void sender(String str)
    {
    String ip="127.0.0.1";

    try
			{

           //   System.out.println("Task is migrated to server 1");
				Socket s1 = new Socket(ip,1254);
                               
				OutputStream s1out = s1.getOutputStream();
				DataOutputStream dos = new DataOutputStream (s1out);
				dos.writeUTF(str);
				dos.close();
				s1out.close();
				s1.close();
			}
			catch(IOException e)
			{
			}
}
}
