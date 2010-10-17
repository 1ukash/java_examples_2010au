package ru.spbstu.telematics.stud;

public class Bar {

	private String strValWithComment = "aaa";
	private String anotherStrValWithComment;
	private static int x = 5;
	
	{
		strValWithComment = "xxx";
	}
	
	static {
		x = 6;
	}

	public Bar(String string) {
		this.strValWithComment = string;
	}

	public String getStrValWithComment() {
		return strValWithComment;
	}
	
	public void foo() {
		int a = 0;
		
		if (a == 2) {
			
		}
		System.out.println("I'm Bar");
	}

}
