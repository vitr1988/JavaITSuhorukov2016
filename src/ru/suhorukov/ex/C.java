package ru.suhorukov.ex;

public interface C extends A {

	default void method() {
		System.out.println("Call method of class C");
	}
}
