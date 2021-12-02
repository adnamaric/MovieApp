package com.course.movie;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MovieApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieApplication.class, args);
		InsertData() ;
	}

    public static void InsertData() {
		try  {
			 Connection con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/Movies","postgres","adna");
			 System.out.println("Uspješno ostvarena veza sa bazom");
			 Statement st=con.createStatement();
			 
			 //genre
			 ResultSet rs = st.executeQuery("SELECT * from Genre");
	         if(rs.next()==true) {
	        	 System.out.println("U bazi već postoje podaci");
	         }
	         else { 
	        	 st.execute("INSERT INTO Genre VALUES(1,'Komedija')");
	        	 st.execute("INSERT INTO Genre VALUES(2,'Drama')");

	    		 System.out.println("Uspješno dodani podaci");
	         }
	         
	         
		     //language
					 rs=st.executeQuery("SELECT * FROM Language");
					 if(rs.next()==true)
					 {
			        	 System.out.println("U bazi već postoje podaci");
			         }
					 else { 
			        	 st.execute("INSERT INTO Language VALUES(1,'Engleski jezik','222')");
			        	 st.execute("INSERT INTO Language VALUES(2,'Njemacki jezik','223')");

			    		 System.out.println("Uspješno dodani podaci");
			         }
			 // country
					 
					 rs=st.executeQuery("SELECT * FROM Country");
					 if(rs.next()==true)
					 {
			        	 System.out.println("U bazi već postoje podaci");
			         }
					 else { 
			        	 st.execute("INSERT INTO Country VALUES(1,111,'Bosna i Hercegovina')");
			        	 st.execute("INSERT INTO Country VALUES(2,111,'Hrvatska')");
			        	 st.execute("INSERT INTO Country VALUES(3,111,'Srbija')");
			    		 System.out.println("Uspješno dodani podaci");
			         }
					 
		     // type
					 
					 rs=st.executeQuery("SELECT * FROM Content_Type");
					 if(rs.next()==true)
					 {
			        	 System.out.println("U bazi već postoje podaci");
			         }
					 else { 
			        	 st.execute("INSERT INTO Content_Type VALUES(1,'Type 1')");
			        	 st.execute("INSERT INTO Content_Type VALUES(2,'Type 2')");
			        	 st.execute("INSERT INTO Content_Type VALUES(3,'Type 3')");
			    		 System.out.println("Uspješno dodani podaci");
			         }
		   //content
				        // columns in db are sorted alphabetically 
				         rs=st.executeQuery("SELECT * FROM Content");
						 if(rs.next()==true)
						 {
				        	 System.out.println("U bazi već postoje podaci za kontent");
				         }
						 else { 
				        	 st.execute("INSERT INTO Content VALUES(1,180,'Title number 1',1991)");
				        	 st.execute("INSERT INTO Content VALUES(2,60,'Title number 2',1992)");

				    		 System.out.println("Uspješno dodani podaci");
				         }
		// movie_role
						 
						 rs=st.executeQuery("SELECT * FROM Movie_Role");
						 if(rs.next()==true)
						 {
				        	 System.out.println("U bazi već postoje podaci");
				         }
						 else { 
				        	 st.execute("INSERT INTO Movie_Role VALUES(1,'Redatelj')");
				        	 st.execute("INSERT INTO Movie_Role VALUES(2,'Kostimograf')");
				        	 st.execute("INSERT INTO Movie_Role VALUES(3,'Direktor scenografije')");
				        	 st.execute("INSERT INTO Movie_Role VALUES(4,'Kamerman')");
				    		 System.out.println("Uspješno dodani podaci");}
        // movie_people
						 
						 rs=st.executeQuery("SELECT * FROM Movie_People");
						 if(rs.next()==true)
						 {
				        	 System.out.println("U bazi već postoje podaci");
				         }
						 else { 
				        	 st.execute("INSERT INTO Movie_People VALUES(1,null,'John','M', 'Wick')");
				        	 st.execute("INSERT INTO Movie_People VALUES(2,null,'Maywick','M', 'Jones')");
				        	 st.execute("INSERT INTO Movie_People VALUES(3,null,'Sandra','F', 'Bullock')");
				        	 st.execute("INSERT INTO Movie_People VALUES(4,null,'Drew','F', 'Barrymore')");
				    		 System.out.println("Uspješno dodani podaci");}
		// season				 
						 rs=st.executeQuery("SELECT * FROM Season");
						 if(rs.next()==true)
						 {
				        	 System.out.println("U bazi već postoje podaci");
				         }
						 else { 
				        	 st.execute("INSERT INTO Season VALUES(1,'Season 1',1,1)");
				        	 st.execute("INSERT INTO Season VALUES(2,'Season 2',2,1)");
				    		 System.out.println("Uspješno dodani podaci");}
		// episode
						 rs=st.executeQuery("SELECT * FROM Episode");
						 if(rs.next()==true)
						 {
				        	 System.out.println("U bazi već postoje podaci");
				         }
						 else { 
				        	 st.execute("INSERT INTO Episode VALUES(1,60,'The Pilot One',1,1)");
				        	 st.execute("INSERT INTO Episode VALUES(2,60,'Where it all starts',2,1)");
				        	 st.execute("INSERT INTO Episode VALUES(3,60,'Drama never stops',3,1)");
				    		 System.out.println("Uspješno dodani podaci");}
			 con.close();
		}
			 catch (Throwable e) {
		            e.printStackTrace();
		        }
			
    }
    
}
