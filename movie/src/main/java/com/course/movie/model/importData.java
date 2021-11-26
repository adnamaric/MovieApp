package com.course.movie.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class importData {
	public static void main (String[] args) {
		try  {
		 Connection con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/Movies","postgres","adna");
		 System.out.println("Uspješno ostvarena veza sa bazom");
		 Statement st=con.createStatement();
		 ResultSet rs = st.executeQuery("SELECT * from Fakultet");
         if(rs.next()==true) {
        	 System.out.println("U bazi već postoje podaci");
         }
         else { 
        	 st.execute("INSERT INTO Fakultet VALUES(1,'FIT',250)");
    		 st.execute("INSERT INTO Student VALUES(1,25,'Adna')");
    		 st.execute("INSERT INTO Student VALUES(2,25,'Test1')");
    		 st.execute("INSERT INTO Student VALUES(3,25,'Test2')");
    		 st.execute("INSERT INTO Student VALUES(4,22,'Test3')");
    		 st.execute("INSERT INTO Student VALUES(5,25,'Test4')");
    		 System.out.println("Uspješno dodani podaci");
         }
		
		
		 con.close();
	}
		 catch (Throwable e) {
	            e.printStackTrace();
	        }
		
		
	}
	
	
}