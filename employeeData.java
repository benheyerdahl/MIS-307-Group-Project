import java.util.Scanner;
import java.util.ArrayList;

/**
 * Class containing methods to input employee information and payroll data
 */
public class employeeData
{
    static ArrayList<Integer> employeeIDs = new ArrayList<Integer>();
    ArrayList<String> employees = new ArrayList<String>();
    ArrayList<String> socNums = new ArrayList<String>();
    ArrayList<Double> wages = new ArrayList<Double>();
    ArrayList<String> employeesLast = new ArrayList<String>();
    ArrayList<String> address = new ArrayList<String>();

    Scanner in = new Scanner(System.in);

    private Integer employeeID = 0;
    private String employeeName = " ";
    private String employeeLastName = " ";
    private String ssnID = " ";
    private double wage = 0.0;
    

    /**
     * Method to input employee data
     * 
     */
    public void setEmployeeInfo()
    {
    	System.out.println("Welcome to 307 Payroll Software v1.12/n");
        System.out.println("Enter new employee name. Press Q to save and quit when finished entering data.");

        while(!employeeName.equalsIgnoreCase("Q"))
        {
        		
        		employeeName = in.next();
                if(employeeName.equalsIgnoreCase("Q"))
                {
                break;
                }
                
                employeeLastName = in.next();
            	System.out.println("Please enter employee SSN: ");
                ssnID = in.next();
            	System.out.println("Please enter employee pay rate: ");
                wage = in.nextDouble();

                Employee.employeeIDs.add(employeeID);
                employeeIDs.add(employeeID);
                employees.add(employeeName);
                employeesLast.add(employeeLastName);
                socNums.add(ssnID);
                wages.add(wage);
                employeeID++;
                

                System.out.println("Employee ID  |  Employee Name        |  SSN          |  Wage");
                for(int i = 0; i < employees.size(); i++)
                { 
                	
                    System.out.printf(employeeIDs.get(i) + "          | " + employees.get(i) + " " + employeesLast.get(i) + "              | " + socNums.get(i) + "          | " + "%1.2f",wages.get(i));
                    System.out.println();
                    
                   
                }
                
        }
    }

    /**
     * A method that gets the list of ACME employee first names added to the record.
     * @return
     * Returns the ArrayList containing the first names of each employee entered.
     */
    public ArrayList<String> getEmployeeArrayList()
    {
        return employees;
    }

    /**
     * A method that gets the list of ACME employee last names added to the record.
     * @return
     * Returns the ArrayList containing the last names of each employee entered.
     */
    public ArrayList<String> getEmployeeLastArrayList()
    {
        return employeesLast;
    }

    /**
     * A method that gets the list of ACME employee tax IDs added to the record.
     * @return
     * Returns the ArrayList containing the tax IDs of each tax ID entered.
     */
    public ArrayList<String> getssnIDsArrayList()
    {
        return socNums;
    }

    /**
     * A method that gets the list of ACME employee wages added to the record.
     * @return
     * Returns the ArrayList containing the wages of each wage entered.
     */
    public ArrayList<Double> getWageArrayList()
    {
        return wages;
    }

}
