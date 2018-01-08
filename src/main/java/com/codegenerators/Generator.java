package com.codegenerators;

import com.codegenerators.freemarker.Freemarker;
import com.codegenerators.velocity.Velocity;

public class Generator {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long startTime = System.currentTimeMillis();
		System.out.println("Welcome to Generator...");
//		freemarkerGeneratorCode();
		velocityGeneratorCode();
		System.out.println("Take time..." + ( System.currentTimeMillis() - startTime) + "ms");
		System.out.println("Done...");
	}
	
	public static void freemarkerGeneratorCode() {
		System.out.println("Welcome to use freemarker generator code...");
		Freemarker fm = new Freemarker();
		fm.run();
	}
	
	public static void velocityGeneratorCode() {
		System.out.println("Welcome to use velocity generator code...");
		Velocity vm = new Velocity();
		vm.run();
	}

}
