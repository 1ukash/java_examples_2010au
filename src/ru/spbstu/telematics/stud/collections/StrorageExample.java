package ru.spbstu.telematics.stud.collections;

import java.util.Arrays;
import java.util.BitSet;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class StrorageExample {
	Collection<String> strings = new TreeSet<String>();
	
	public static void main(String[] args) {
		new StrorageExample().baz();
		new StrorageExample().bar();
		new StrorageExample().bar();
		new StrorageExample().bzz();
		new StrorageExample().bit();
		
	}

	private void bit() {
		BitSet set = new BitSet(10);
		
		set.set(2);
		set.get(1);
		set.clear(9);
		
		BitSet set2 = null;
		
		set.or(set2 );
	}

	private void bzz() {
		List<Integer> list = Arrays.asList(10, 11, 12, 13, 29);
		List<Object> emptyList = Collections.emptyList();
		
		List<Integer> readOnly = Collections.unmodifiableList(list);
		readOnly.add(10);
	}
	
	

	private void bar() {
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("abc", new Integer(10));
		map.put("abd", new Integer(11));
		map.put("abe", new Integer(12));
		
		System.out.println((Integer) map.get("abc"));
	}

	private void baz() {
		
		strings.add("Abc");
		strings.add("Ydz");
		strings.add("Xoo");
		strings.add("Xoo");
		//strings.add(10);
		
		Iterator<String> it = strings.iterator();
		
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		
		for (String str : strings) {
			System.out.println(" FOR EACH " + str);
		}
		
	}
}
