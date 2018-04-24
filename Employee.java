import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * A class that contains methods for entering payroll information for each ACME employee. This class uses methods from the EmployeeRecord class in order to run and therefore, relies on the EmployeeRecord class to operate.
 */
public class Employee
{
	// ArrayLists that will implement return methods from the EmployeeRecord class.
	ArrayList<String> eMp;
	ArrayList<String> eMpL;
	ArrayList<Double> eW;

		static ArrayList<Integer> employeeIDs = new ArrayList<Integer>();

	// Instance Variables used in setEmployeePayroll() method.


	private int terminate = 1000;
	private int i = 0;

		// ArrayLists used to store values in setEmployeePayroll() method.

		ArrayList<Double> hours = new ArrayList<Double>();
		ArrayList<Double> tPay = new ArrayList<Double>(); 
		
				// Local variables used in this method.
		double totalPay;
		double totalHours = 0;
		double overTime;
		double hoursWorked = 0.0;
		int eID;

	Scanner in = new Scanner(System.in);

	/**
	 * A method that implements the EmployeeRecord class to prompt the user to enter information for the payroll of each ACME employee. The payroll for each employee is then displayed.
	 */
	public void setEmployeePayroll()
	{
		
		
		

		
		// Constructs a new EmployeeRecord to implement classes from EmployeeRecord class.
		employeeData e = new employeeData();
		e.setEmployeeInfo();

		eMp = e.getEmployeeArrayList();
		eMpL = e.getEmployeeLastArrayList();
		eW = e.getWageArrayList();


		System.out.println("Please enter ACME employee ID and the number of hours worked. This information should be entered in the order the names were entered. Enter 0 when you are done inputing information.");
		eID = in.nextInt();
		System.out.println("Enter hours worked:");
		hoursWorked = in.nextDouble();


		while(terminate != 0)
		{

			terminate = in.nextInt();
			if(terminate == 0)
			{
				break;
			}



			// Checks to see if an employee receives a 150% bonus on their payroll.
			if(hoursWorked > 0 && hoursWorked <= 40)
			{
				
				hours.add(hoursWorked);
				totalPay = hoursWorked * (eW.get(i));
				tPay.add(totalPay);


			}

			else if(hoursWorked > 40)
			{
				overTime = hoursWorked - 40;

				totalHours = hoursWorked + overTime;
				hours.add(totalHours);
				totalPay = totalHours * (eW.get(i)) + (1.5 * (overTime));
				tPay.add(totalPay);


			}

			i = terminate;
		}

		// Constructs a new date format for the date of the payroll.
		DateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date d = new Date();

		// Gets current date and time for payroll.
		System.out.println("ACME Payroll run on " + format.format(d));
		
		//test print lines in attempt to debug why variables arent going into array
		System.out.println(totalHours );
		System.out.println(eID);
		System.out.println(employeeIDs.get(eID - 1) + " "  + " " + eMp.get(1) + eMpL.get(1) + hoursWorked + hours + tPay + eW.get(1));
		
		
		System.out.println("Employee Number  |  Employee Name    |  Hours Worked  |  Total Pay");

		System.out.println(employeeIDs.get(eID - 1) + "                | " + eMp.get(i) + " " + eMpL.get(i) + "        | ");

	}
}
