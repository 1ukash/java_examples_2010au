package ru.spbstu.telematics.stud.streams;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipOutputStream;

public class FilterExample {

	public static void main(String[] args) throws Exception {
		FileOutputStream fout = new FileOutputStream("/tmp/test.zip");
		//ZipOutputStream zip = new ZipOutputStream(fout);
		BufferedOutputStream cout = new BufferedOutputStream(fout);

		cout.write("hello zip archive!".getBytes());
		
		cout.flush();
		cout.close();
		
		
	}
	
}
