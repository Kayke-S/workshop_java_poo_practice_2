package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {
	
	public static void main(String[] args) {
	
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter department's name: ");
		String department = sc.nextLine();
		System.out.println("Enter worker data: ");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Level: ");
		WorkerLevel level = WorkerLevel.valueOf(sc.nextLine());
		System.out.print("Base Salary: ");
		Double baseSalary = sc.nextDouble();
		
		Worker worker = new Worker(name, baseSalary, level, new Department(department));
		
		System.out.print("How many contracts to this worker? ");
	    int n = sc.nextInt();
	    
	    sc.nextLine();
	    
	    for(int i = 0; i < n; i++) {
	    	System.out.println("Enter contract #" + (i+1) + " data:");
	    	System.out.print("Date (DD/MM/YYYY): ");
	    	String Date = sc.nextLine();
	    	System.out.print("Value per hour: ");
	    	Double valuePerHour = sc.nextDouble();
	    	System.out.print("Duration (hours): ");
	    	Integer duration = sc.nextInt();
	    	
	    	worker.addContracts(new HourContract(Date, valuePerHour, duration));
	    	sc.nextLine();
	    }
	    
	    System.out.println();
	    System.out.print("Enter month and year to calculate income (MM/YYYY): ");
	    String monthAndYear = sc.nextLine();
	    
	    String[] vect =  monthAndYear.split("/");
	    Double totalValue = worker.income(Integer.parseInt(vect[1]), Integer.parseInt(vect[0]));
	  
	    System.out.println("Name: " + worker.getName());
	    System.out.println("Department: " + worker.getDepartment().getName());
	    System.out.println("Income for " + monthAndYear + ": " + String.format("%.2f", totalValue));
		
	    
	    sc.close();
		
	}
}