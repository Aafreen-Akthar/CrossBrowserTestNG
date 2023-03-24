package edu.training.flipkart.singleton;

public class SingletonClass {
	private static SingletonClass instanceOfSingletonClass;
	private SingletonClass() {
		System.out.println("Instance created");
	}
	
	public static SingletonClass getInstanceofSingletonClass() {
		if(instanceOfSingletonClass==null) {
			instanceOfSingletonClass = new SingletonClass();
		}
		return instanceOfSingletonClass;
	}

}
