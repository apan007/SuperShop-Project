package com.example.Main;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;
public class DbConnection {
	public static Connection Con = null;
	public static Statement Sta = null;
	
	public static void connect() {
		String serverName="",port="",userName="",Password="",databaseName="";
			
			try {
				
				File file=new File("src/dbconnection.txt");
				Scanner scan=new Scanner(file);
				int a=1;
				while(scan.hasNextLine()) {
					
					String s=scan.nextLine();
					StringTokenizer token=new StringTokenizer(s);
					token.nextToken();
					
					if(a==1) {
						serverName=token.nextToken();
					}
					else if(a==2) {
						port=token.nextToken();
					}
					else if(a==3) {
						userName=token.nextToken();
					}
					else if(a==4) {
						databaseName=token.nextToken();
					}
					a++;	
				}
				String url="jdbc:mysql://"+serverName+":"+port+"/"+databaseName;
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				Con=DriverManager.getConnection(url,userName,Password);
				Sta= Con.createStatement();
				System.out.println("Connected");
			}
			
			catch(Exception e) {
				
				JOptionPane.showMessageDialog(null, e);
			}
		
	}
}
