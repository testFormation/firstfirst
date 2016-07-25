package org.formation.util;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Singleton s=Singleton.getInstance();
		System.out.println(s);
		Singleton s1=Singleton.getInstance();
		System.out.println(s1);

	}

}
