import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
// Hello git repository
/**
 * A class that contains methods for entering payroll information for each ACME employee. This class uses methods from the EmployeeRecord class in order to run and therefore, relies on the EmployeeRecord class to operate.
 */
public class Employee
{
	// ArrayLists that will implement return methods from the EmployeeRecord class.
	ArrayList<String> employeeFirst;
	ArrayList<String> employeeLast;
	ArrayList<Double> employeeWage;


	// ArrayLists used to store values in setEmployeePayroll() method.
	static ArrayList<Integer> employeeIDs = new ArrayList<Integer>();
	ArrayList<Double> hours = new ArrayList<Double>();
	ArrayList<Double> tPay = new ArrayList<Double>(); 

	// Instance Variables used in setEmployeePayroll() method.


	private int terminate = 1000;
	private int i = 0;
	private double hoursWorked = 0.0;
	int counter = 0;
	Scanner in = new Scanner(System.in);

	/**
	 * A method that implements the EmployeeRecord class to prompt the user to enter information for the payroll of each ACME employee. The payroll for each employee is then displayed.
	 */
	public void setEmployeePayroll()
	{

		// Constructs a new EmployeeRecord to implement classes from EmployeeRecord class.
		employeeData e = new employeeData();
		e.setEmployeeInfo();


		employeeFirst = e.getEmployeeArrayList();
		employeeLast = e.getEmployeeLastArrayList();
		employeeWage = e.getWageArrayList();


		// Local variables used in this method.
		double totalPay = 0.0;
		double totalHours = 0.0;
		double overTimeHours = 0.0;
		int eID = 0;

	while(eID != -1) {

		System.out.println("Please enter employee ID: . Enter -1 for employee ID and 0 for hours when you are done inputing information.");
		eID = in.nextInt();
		i = eID;
		System.out.println("Enter hours worked:");
		hoursWorked = in.nextDouble();

		if(hoursWorked != 0 || eID == -1)
		{


			// Checks to see if an employee earned overtime
			if(hoursWorked > 0 && hoursWorked <= 40)
			{

				hours.add(hoursWorked);
				totalPay = hoursWorked * (employeeWage.get(i));
				tPay.add(totalPay);
				totalPay = 0;
				hoursWorked = 0;
				
			}

			if(hoursWorked > 40)
			{
				overTimeHours = hoursWorked - 40;
				
				totalHours = 40 + overTimeHours;
				hours.add(hoursWorked);
				totalPay = ((employeeWage.get(i)) * 40) + (1.5 * (employeeWage.get(i)) * (overTimeHours));
				tPay.add(totalPay);
				totalPay = 0;
				hoursWorked = 0;
				
			}
		}
		else {
			System.out.println("Shutting down. Have a good day!");
			System.exit(0);
		}

		DateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date d = new Date();

		System.out.println("ACME Payroll run on " + format.format(d));
		i = eID;
		System.out.println();
		System.out.println("Employee Number  |  Employee Name    |  Hours Worked  |  Total Pay");
		System.out.println(employeeIDs.get(eID) + "                | " + employeeFirst.get(i) + " " + employeeLast.get(i) + "        | " + hours.get(counter) + "           | " + tPay.get(counter));
		counter++;
	
/**
 * Variable tester for arraylists
 * 
 * System.out.println(counter + " counter");
		System.out.println(tPay + " total pay");
		System.out.println(hours + " total hours");
		System.out.println(employeeIDs + " emp IDs");
		System.out.println(employeeFirst + " first name");
		System.out.println(employeeLast + " last name");
		

 */
		

	}

	}


}
