package ru.spbstu.telematics.stud.reflections;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Main {
	
	public static void main(String[] args) throws Exception {
		Foo foo = new Foo(1, "c");
		
		Class clazz= Foo.class;
		System.out.println(clazz.getCanonicalName());
		
		testClass(clazz.getCanonicalName());
		testConstructor("ru.spbstu.telematics.stud.reflections.Foo");
		
	}

	private static void testConstructor(String string) throws Exception {
		// TODO Auto-generated method stub
		Class trz = Class.forName(string);
		Constructor[] zzzx = trz.getDeclaredConstructors();
		for(int i=0; i<zzzx.length; i++){
			Constructor zz = zzzx[i];
			System.out.println(zz.hashCode());
		}
		Constructor yy = trz.getDeclaredConstructor(Integer.class, String.class);
		Object obj = yy.newInstance(new Integer(7), new String("fofofo"));
		Foo fo = (Foo) obj;
		System.out.println(fo.getB());
	}

	private static void testClass(String name) throws Exception {

		Class cl = Class.forName(name);
		Object obj = cl.newInstance();
		Foo  f = (Foo) obj;
		f.setA(10);
		System.out.println(f.getA());
		
		Method[] methods = cl.getDeclaredMethods();
		for (Method m : methods) {
			System.out.println(m.getName());
		}
		
		Method m = cl.getDeclaredMethod("getA");
		Object res = m.invoke(f);
		System.out.println("Result is: " + res.toString());
		
	}
	
}
