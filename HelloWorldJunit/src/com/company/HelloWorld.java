package com.company;

public class HelloWorld {
    String str;
    public void sayHelloWorld() {
	   str = "Hello world";
	   System.out.println("Hello World!");
    }
    public String getStr() {
	    return str;
    }
    public static void main(String[] args) {
	    HelloWorld helloworld = new HelloWorld();
	    helloworld.sayHelloWorld();
        return;
    }
}
