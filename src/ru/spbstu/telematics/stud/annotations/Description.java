package ru.spbstu.telematics.stud.annotations;

public @interface Description {
	String title();
	int version() default 1;
}
