package ru.spbstu.telematics.stud.exceptions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Example {
	public static void main(String[] args) {
		
		Example ex = new Example();
		//ex.runtimeTest();
			ex.test();
		
	}

	private void test() {
		File f = new File("/tmp/t.txt");
		
		try {
			FileInputStream in = new FileInputStream(f);
		} catch (FileNotFoundException e) {
			//e.printStackTrace();
			throw new FooException("oops");
		}
	}

	private void runtimeTest() {
		Object obj = null;
		obj.hashCode();
	}
}
