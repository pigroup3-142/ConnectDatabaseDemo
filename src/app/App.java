package app;

import java.io.IOException;

import org.xml.sax.SAXException;

import packagejdbc.QueryDB;

public class App {
	public static void main(String[] args) throws SAXException, IOException {
		QueryDB sta = new QueryDB();
		sta.printResult();
	}
}
