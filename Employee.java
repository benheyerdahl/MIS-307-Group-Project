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

    // ArrayLists used to store values in setEmployeePayroll() method.
    static ArrayList<Integer> employeeIDs = new ArrayList<Integer>();
    ArrayList<Double> hours = new ArrayList<Double>();
    ArrayList<Double> tPay = new ArrayList<Double>();

    // Instance Variables used in setEmployeePayroll() method.
    private String employeeId = "%03d";
    private int weekNumber = 0;
    private double hoursWorked = 1.0;
    private double hoursWorked2 = 1.0;
    private int terminate = 1000;
    private int i = 0;


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

        // Local variables used in this method.
        double totalPay = 0.0;
        double totalHours = 0.0;
        double overTime = 0.0;
        double overTime2 = 0.0;

        System.out.println("Please enter ACME employee ID, the week they worked (1 or 2), and the number of hours worked. This information should be entered in the order the names were entered. Enter 0 when you are done inputing information.");

                totalHours = in.nextDouble();
        
        while(in.nextInt() != 0)
        {
    
            terminate = in.nextInt();
            if(terminate == 0)
            {
                break;
            }



            // Checks to see if an employee receives a 150% bonus on their payroll.
            if(hoursWorked > 0 && hoursWorked <= 40 && hoursWorked2 > 0 && hoursWorked2 <= 40)
            {
                totalHours = hoursWorked + hoursWorked2;
                hours.add(totalHours);
                totalPay = totalHours * (eW.get(i));
                tPay.add(totalPay);
                hoursWorked = 0.0;
                hoursWorked2 = 0.0;
            }
            else if(hoursWorked2 > 40 && hoursWorked > 0 && hoursWorked <= 40)
            {
                overTime2 = hoursWorked2 - 40;
                totalHours = hoursWorked + hoursWorked2;
                hours.add(totalHours);
                totalPay = totalHours * (eW.get(i)) + (overTime2 * 1.5);
                tPay.add(totalPay);
                hoursWorked = 0.0;
                hoursWorked2 = 0.0;
            }
            else if(hoursWorked > 40 && hoursWorked2 <= 40 && hoursWorked2 > 0)
            {
                overTime = hoursWorked - 40;
                totalHours = hoursWorked + hoursWorked2;
                hours.add(totalHours);
                totalPay = totalHours * (eW.get(i)) + (overTime * 1.5);
                tPay.add(totalPay);
                hoursWorked = 0.0;
                hoursWorked2 = 0.0;
            }
            else if(hoursWorked > 40 && hoursWorked2 > 40)
            {
                overTime = hoursWorked - 40;
                overTime2 = hoursWorked2 - 40;
                totalHours = hoursWorked + hoursWorked2;
                hours.add(totalHours);
                totalPay = totalHours * (eW.get(i)) + (1.5 * (overTime + overTime2));
                tPay.add(totalPay);
                hoursWorked = 0.0;
                hoursWorked2 = 0.0;
            }
            hours.add(totalHours);
            tPay.add(totalPay);

            i = terminate;
        }

        // Constructs a new date format for the date of the payroll.
        DateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date d = new Date();

        // Gets current date and time for payroll.
        System.out.println("ACME Payroll run on " + format.format(d));
        System.out.println(employeeIDs.get(1) + eMp.get(1) + eMpL.get(1) + totalHours + totalPay + eW.get(0));
        System.out.println("Employee Number  |  Employee Name    |  Hours Worked  |  Total Pay");
        for(int i = 0; i < e.getEmployeeArrayList().size(); i++)
        {
            System.out.println(employeeIDs.get(i) + "              | " + eMp.get(i) + " " + eMpL.get(i) + "        | " + hours.get(i) + "           | " + tPay.get(i));
        }
    }
}