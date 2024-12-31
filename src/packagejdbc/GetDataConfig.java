package packagejdbc;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class GetDataConfig {
	private String dbURL;
	private String username;
	private String password;
	private String tableName;
	
	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getDbURL() {
		return dbURL;
	}
	
	public void setDbURL(String dbURL) {
		this.dbURL = dbURL;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public GetDataConfig() throws SAXException, IOException {
		// init value temp
		String temp1 = null;
		String temp2 = null;
		String temp3 = null;
		String temp4 = null;
		
		// get value from file config.xml
		try {
			// init doc
			File fxml = new File("config/config.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbFactory.newDocumentBuilder();
			Document doc = db.parse(fxml);
			doc.getDocumentElement().normalize();
			
			// get database URL
			temp1 = doc.getElementsByTagName("dbURL").item(0).getTextContent();
			// get username
			temp2 = doc.getElementsByTagName("username").item(0).getTextContent();
			// get password
			temp3 = doc.getElementsByTagName("password").item(0).getTextContent();
			// get tablename 
			temp4 = doc.getElementsByTagName("tablename").item(0).getTextContent();
		} catch (ParserConfigurationException e) {
			// NULL
		}
		
		// set value
		setDbURL(temp1);
		setUsername(temp2);
		setPassword(temp3);
		setTableName(temp4);
	}
}
