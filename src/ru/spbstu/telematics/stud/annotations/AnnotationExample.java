package ru.spbstu.telematics.stud.annotations;

import java.util.ArrayList;
import java.util.List;


/**
 * 
 * @author lukash
 */
public class AnnotationExample {
	
	@Description(title = "foo", version = 2)
	class Foo {
		int field;
		
		@SuppressWarnings({ "rawtypes", "unused" })
		void bar() {
			List l = new ArrayList();
		}
	}
	
	class Baz extends Foo {

		@Override
		void bar() {
			super.bar();
		}
		
	}
	
	@Deprecated
	private void foo() {

	}
	
	

}
