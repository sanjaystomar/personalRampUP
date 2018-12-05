package org.personal.rampup.collections;

import java.util.ArrayList;
import java.util.List;

public class AlternateExample {

	public static void main(String[] args) {
		
		for( int n=1, m=10; n <= 10;n++,m--) {
			System.out.println(n + " : " + m);
		}
		
		System.out.println("oooooooooooooo");
		List<Integer> intList = new ArrayList<>();
		intList.add(10);
		intList.add(15);
		intList.add(18);
		intList.add(20);
		addAll(intList, 1,2,3,4,5 );
		

	}
	
	public static <T> void addAll(List<T> list, T...arr) {
		for(T elt : arr) list.add(elt); System.out.println(list.toString());
	}

}
