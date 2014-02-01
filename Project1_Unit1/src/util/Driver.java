/*
 * Xuefeng Zhai
 * xzhai@cmu.edu
 */
package util;

import model.Automobile;

public class Driver {

	public static void main(String[] args) {
		
		FileIO fio = new FileIO();
		Automobile FordZTW = fio.buildAutoObject("src/data1.txt");
		FordZTW.print();
		
		System.out.println();
		System.out.println("Serialize...");
		fio.serializeAuto(FordZTW);
		
		System.out.println();
		System.out.println("Deserialize...");
		Automobile newFordZTW = fio.deserializeAuto("src/serializeAuto.dat");
		
		System.out.println();
		newFordZTW.print();
				
	}

}
