package ru.spbstu.telematics.stud.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface PermissionRequired {
	Permission value() default Permission.USER;
}
