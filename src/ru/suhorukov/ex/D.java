package ru.suhorukov.ex;

public interface D extends B, C {

	default void method() {
		B obj = (B) this;
		C obj2 = (C) this;
		obj.method();
		obj2.method();
	}
}
