package com.company;
import static org.junit.Assert.*;
import org.junit.Test;

public class HelloWorldTest {
	public HelloWorld helloworld = new HelloWorld();
	@Test
	public void TestHelloWorld() {
		helloworld.sayHelloWorld();
		assertEquals("Hello World!", helloworld.getStr());
	}
}
