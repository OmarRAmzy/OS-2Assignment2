package Disk.scheduling;

public class Main {

	public static void main(String[] args) {

		Algorithms A = new Algorithms();
	//	98, 183, 37, 122, 14, 124, 65, 67
		
		System.out.println("\n");
		System.out.println("FCFS");
		A.FCFS();
		System.out.println("\n");
		System.out.println("SSTF");
		A.SSTF();	
		System.out.println("\n");
		System.out.println("SCAN");
		A.Scan();	
		System.out.println("\n");
		System.out.println("LOOK");
		A.Look();
		System.out.println("\n");
		System.out.println("C_Scan");
		A.C_Scan();
		System.out.println("\n");
		System.out.println("C_Look");
		A.C_LOOK();

		
		
	}

}
