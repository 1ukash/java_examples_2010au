package ru.spbstu.telematics.stud.eh;

import ru.spbstu.telematics.stud.Bear;
import ru.spbstu.telematics.stud.WhiteBear;

public class EqualsExample implements Cloneable {
	private int number;
	private String name;
	private Bear michael = new WhiteBear();
	
	public EqualsExample(int number, String name) {
		super();
		this.number = number;
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public String getName() {
		return name;
	}

	@Override
	public int hashCode() {
		return getName().hashCode() ^ getNumber() >>> 16;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof EqualsExample) {
			EqualsExample other = (EqualsExample) obj;
			return getName().equals(other.getName()) && getNumber() == other.getNumber();
		}
		return false;
	}

	@Override
	public String toString() {
		return "EqualsExample [number=" + number + ", name=" + name + "]";
	}

	public EqualsExample copy() throws CloneNotSupportedException {
		return (EqualsExample) this.clone();
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		//do all deep operations
		EqualsExample ex = (EqualsExample) this.clone();
		ex.michael = new WhiteBear();
		//do more operations
		return ex;
	}
}
