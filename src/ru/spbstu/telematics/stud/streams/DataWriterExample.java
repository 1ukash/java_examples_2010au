package ru.spbstu.telematics.stud.streams;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.util.Set;

public class DataWriterExample {
	
	public static void main(String[] args) throws IOException {
		binary();
		text();
		file();
	}

	private static void binary() throws FileNotFoundException, IOException {
		FileOutputStream f = new FileOutputStream("/tmp/xxx" + System.currentTimeMillis());
		DataOutputStream dout = new DataOutputStream(f);
		
		dout.writeBoolean(true);
		dout.writeLong(5L);
		dout.writeDouble(.5);
		
		f.close();
	}
	private static void text() throws FileNotFoundException, IOException {
		FileWriter f = new FileWriter("/tmp/yyy" + System.currentTimeMillis());
		f.write("hello world");
		f.close();
		
		Charset cs = Charset.forName("UTF-8");
		Set<String> aliases = cs.aliases();
	
	}

	private static void file() throws FileNotFoundException {
		File f = new File("/tmp/zzz" + System.currentTimeMillis());
		FileInputStream stream = new FileInputStream(f);
		
		if (f.isDirectory()) {
		}
		
		RandomAccessFile rand = null;
	}

}
