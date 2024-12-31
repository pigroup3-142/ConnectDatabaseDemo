package packagejdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.xml.sax.SAXException;
public class QueryDB {
	public void printResult() throws SAXException, IOException {
		
		// Init object get data config from file config.xml
		GetDataConfig connectDB = new GetDataConfig();
		
		// Query to database
		try {
			Connection conn = DriverManager.getConnection(connectDB.getDbURL(),connectDB.getUsername(),connectDB.getPassword());
			
			Statement stat = conn.createStatement();
			
			ResultSet resul = stat.executeQuery("select * from " + connectDB.getTableName());
			
			if(!resul.isBeforeFirst()) {
				System.out.println("No data in table!");
				return;
			}
			
			while(resul.next()) {
				System.out.println(resul.getInt(1) + " " + resul.getString(2) + " " + resul.getString(3));	
			}
			
			conn.close();
		} catch (Exception e) {
			System.out.println("connect fault!");
		}
	}
}
