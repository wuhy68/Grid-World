package com.company;

import org.junit.Before;

public abstract class BaseTest {
	protected HelloWorld helloWorld;

	@Before
	public void initHelloWorld() {
		helloWorld = new HelloWorld();
	}
}
