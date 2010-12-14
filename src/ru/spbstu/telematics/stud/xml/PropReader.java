package ru.spbstu.telematics.stud.xml;

import java.io.IOException;
import java.util.Properties;

public class PropReader {
	public static void main(String[] args) throws IOException {
		Properties props = new Properties();
		
		props.load(PropReader.class.getResourceAsStream("/data.properties"));
		
		String s = props.getProperty("jdk");
		System.out.println(s);
	}
}
