import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Class containing methods to input employee information and payroll data
 */
public class EmployeeData
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
     * @throws IOException 
     * 
     */
    public void setEmployeeInfo() throws IOException
    {   
    	DateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date d = new Date();
		       
    	File f = new File("EmployeeInformation.txt");
    	FileWriter fr = new FileWriter(f , true);
    	BufferedWriter bw = new BufferedWriter(fr);
    	System.out.println("Welcome to 307 Payroll Software v1.12");
    	System.out.println();
        System.out.println("Enter new employee name. Press Q to save and quit when finished entering data.");

	
        while(!employeeName.equalsIgnoreCase("Q"))
        {
        		
        		employeeName = in.next();
                if(employeeName.equalsIgnoreCase("Q"))
                {
                break;
                }
                
                employeeLastName = in.next();
            	System.out.println("Please enter last 4 digits of employee SSN: ");
                ssnID = in.next();
            	System.out.println("Please enter employee pay rate per hour: ");
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
                	
                    System.out.printf(employeeIDs.get(i) + "            | " + employees.get(i) + " " + employeesLast.get(i) + "              | " + socNums.get(i) + "          | " + "$" + wages.get(i));
                    System.out.println();
                    

            		
                   
                }
                
        }	
        for(int i = 0; i < employees.size(); i++)
        { 
        	

    		bw.write("Employee: ");
    		bw.newLine();
    		bw.write(employeeIDs.get(i) + "          | " + employees.get(i) + " " + employeesLast.get(i) + "              | " + "SSNID: " + socNums.get(i) + "          | " + wages.get(i) + "/hour");
    		bw.newLine();
    	
    		
           
        }
        bw.close();
        
    }

    /**
     * A method that gets the list of  employee first names added to the record.
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
