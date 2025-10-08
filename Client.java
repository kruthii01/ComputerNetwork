/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;
import java.net.*;
import java.io.*;
import java.util.*;

public class Client {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        Socket clientSocket=new Socket("127.0.0.1",4000);
        System.out.println("****client server****");
         System.out.println("enter the filename to transfer");
         String fname=sc.nextLine();
          OutputStream ostream= clientSocket.getOutputStream();
          PrintWriter pwrite=new PrintWriter(ostream,true);
          pwrite.println(fname);
          InputStream istream=clientSocket.getInputStream();
          BufferedReader socketRead=new BufferedReader(new InputStreamReader(istream));
          System.out.println("contents of the file"+fname+"are");
          String str;
          while((str=socketRead.readLine())!=null){
              System.out.println(str);
          }
          pwrite.close();
          socketRead.close();
          
        
    }    
    }

    

