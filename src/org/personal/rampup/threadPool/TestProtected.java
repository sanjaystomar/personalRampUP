package org.personal.rampup.threadPool;

import org.personal.rampup.serialization.basic.SerializationEample1;

public class TestProtected extends SerializationEample1 {
	public static void main (String [] args) {
//		SerializationEample1 ss = new TestProtected();
//		System.out.println(ss.fun);
		
		TestProtected tp = new TestProtected();
		tp.testPro();
	}
	
	public void testPro() {
		System.out.println(fun);
		SerializationEample1 ss = new SerializationEample1();
//		System.out.println(ss.fun);
		
	}
}
