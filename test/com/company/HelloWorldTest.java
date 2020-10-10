package com.company;

import static org.junit.Assert.*;
import org.junit.Test;

public class HelloWorldTest extends BaseTest {

	@Test
	public void helloJunitTest() {
		assertNotNull(helloWorld.helloJunit(3));
		assertSame(3, helloWorld.helloJunit(3));
		assertNotSame(2, helloWorld.helloJunit(3));
		assertNotSame(4, helloWorld.helloJunit(3));
	}
}
