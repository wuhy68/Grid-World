package com.company;

public class HelloWorld {
    private String str;
    public void sayHelloWorld() {
	   str = "Hello world";
	   System.out.print("Hello World!");
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
