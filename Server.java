/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;
import java.net.*;
import java.io.*;
import java.util.*;


public class Server {

   
    public static void main(String[] args)throws Exception {
        ServerSocket servSocket=new ServerSocket(4000);
        System.out.println("***serverside***");
        System.out.println("server ready for connection");
        Socket connSock=servSocket.accept();
        System.out.println("connection is succesful and ready for file transfer");
        
         InputStream istream= connSock.getInputStream();
         BufferedReader fileRead=new BufferedReader(new InputStreamReader(istream));
         String fname=fileRead.readLine();
         File fileName=new File(fname);
         OutputStream ostream= connSock.getOutputStream();
         PrintWriter pwrite=new PrintWriter(ostream,true);
         if(fileName.exists()){
             BufferedReader contentRead=new BufferedReader (new FileReader(fname));
             System.out.println("writing file contents to the sockets:");
             String str;
             while((str=contentRead.readLine())!=null){
                 pwrite.println(str);
         }
         contentRead.close();
    }
    else
    {
        System.out.println("requested file doesnt exists");
        String msg="Requested file doesnt exist at server side";
         pwrite.println(msg);
         }
    connSock.close();
  servSocket.close();
  fileRead.close();
  pwrite.close();
    }
}
                 
        
    