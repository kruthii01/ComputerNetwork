/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;
import java.net.*;
import java.util.Scanner;
public class server1 {
    public static void main(String[] args) throws Exception{
        Scanner in=new Scanner(System.in);
        DatagramSocket serverSocket=new DatagramSocket(9000);
         byte[] receiveData=new byte[1024];
          byte[] sendData=new byte[1024];
         System.out.println("Server side");
         DatagramPacket receivePacket=new DatagramPacket(receiveData,receiveData.length);
         serverSocket.receive(receivePacket);
         System.out.println(new String(receivePacket.getData()));
          InetAddress IPAddress=receivePacket.getAddress();
          int port=receivePacket.getPort();
          while(true)
          {
              System.out.println("type some message to be displayed at the client side");
              String message=in.nextLine();
              sendData=message.getBytes();
              System.out.println("message sent from server"+new String(sendData));
              DatagramPacket sendPacket=new DatagramPacket (sendData,sendData.length,IPAddress,port);
              serverSocket.send(sendPacket);
          }
       
    }
    
}