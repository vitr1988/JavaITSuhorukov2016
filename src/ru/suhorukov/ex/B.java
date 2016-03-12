package ru.suhorukov.ex;

public interface B extends A {

	default void method() {
		System.out.println("Call method of class B");
	}
}
