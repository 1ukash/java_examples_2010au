package ru.spbstu.telematics.stud.collections;

import java.io.Serializable;

public class Generics {
	
	private static class Pair<T, U> {
		private T first;
		private U second;
		
		public T getFirst() {
			return first;
		}
		public void setFirst(T first) {
			this.first = first;
		}
		public U getSecond() {
			return second;
		}
		public void setSecond(U second) {
			this.second = second;
		}
	}
	
	public static <T> T getMiddle(T[] a) {
		return a[a.length / 2];
	}
	
	public static <T extends Pair<String, String>> T getSmth(T[] a) {
		return a[a.length / 2];
	}

	
	public static void main(String[] args) {
		Pair<String, Integer> t = new Pair<String, Integer>();
		
		String[] ss = {"A", "B", "C"};
		String x = getMiddle(ss);
	}

}
