package ru.spbstu.telematics.stud.streams;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Stalin {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Person dissident = new Person("Solzhenitsyn", "13-666", "Solovki", 30); 
		String fname = "/tmp/kolyma" + System.currentTimeMillis();
		FileOutputStream fout = new FileOutputStream(fname);
		ObjectOutputStream sout = new ObjectOutputStream(fout);
		sout.writeObject(dissident);
		fout.close();
		
		FileInputStream fin = new FileInputStream(fname);
		ObjectInputStream sin = new ObjectInputStream(fin);
		Person thatDissident = (Person)sin.readObject();
	}

}
