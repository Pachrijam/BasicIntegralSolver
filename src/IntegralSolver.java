import java.util.Scanner;

public class IntegralSolver {
    //computes def. integral
    public String definiteIntegral(double lowerBound, double upperBound, String contents, String type)
    {
        //if bounds are equal
        if(lowerBound == upperBound)
        {
            return "Output: 0";
        }
        //computing integral based on type
        if(type.equals("exponential")){}
        if(type.equals("trig-based")){}
        if(type.equals("logarithmic")){}
        if(type.equals("polynomial")){}
    
        return "Output: ";
    }
    //computes indef. integral
    public String indefiniteIntegral(String contents, String type)
    {
        //initialized constant variables
        double c = 1.0;
        double k = 1.0;
        
        contents = contents.replace(" ", "");
        
        //EXPONENTIAL
        if(type.equals("exponential")){
            
            //check for e^x
            if(contents.equals("e^x")){return "Output: e^x + C";}
            //general case
            if(contents.matches("[-]?\\d*\\.?\\d*e\\^\\([-]?\\d*\\.?\\d*x\\)")){
        
        int eIndex = contents.indexOf("e");

        //extract coefficient (c)
        if(eIndex > 0){
            String coeffStr = contents.substring(0, eIndex);

            if(coeffStr.equals("-")) c = -1;
            else if(!coeffStr.equals("")) c = Double.parseDouble(coeffStr);
        }

        //extract k (inside exponent)
        int start = contents.indexOf("(") + 1;
        int end = contents.indexOf("x");

        String kStr = contents.substring(start, end);

        if(kStr.equals("") || kStr.equals("+")) k = 1;
        else if(kStr.equals("-")) k = -1;
        else k = Double.parseDouble(kStr);

        double newCoeff = c / k;
        return "Output: " + newCoeff + "e^(" + k + "x) + C";
    }
        return "Output: Unsupported function.";
        }






        if(type.equals("trig-based")){}
        if(type.equals("logarithmic")){}
        if(type.equals("polynomial")){}

        return "penis";
    }
    //main method       
    public static void main(String[] args) throws Exception {
    
    Scanner scan = new Scanner(System.in);
    System.out.print("Hello! Welcome to Integral Solver!\n----------------------------------------------------------------\nEnter \'Y\' for definite integral or \'N\' for indefinite integral: ");
    String deforIndef = scan.nextLine();
    

    //prints results of the definite integral
    if(deforIndef.toLowerCase().equals("y"))
    {
        System.out.print("Is your equation Exponential, Trig-based, Logarithmic, or a Polynomial?: ");
        String type = scan.nextLine();
        if(!type.toLowerCase().equals("exponential")&&!type.toLowerCase().equals("trig-based")&&!type.toLowerCase().equals("logarithmic")&&!type.toLowerCase().equals("polynomial"))
        {
            System.out.println("Sorry! That's invalid! Please try again.");
        }
        else
        {
        System.out.print("Enter lower bound: ");
        double lowerBound = scan.nextDouble(); 
        System.out.print("Enter upper bound: ");
        double upperBound = scan.nextDouble();
        scan.nextLine();
        System.out.print("Enter the integrand with respect to \'x\': ");
        String contents = scan.nextLine();
        System.out.println("----------------------------------------------------------------\nInput: Definite integral of " + contents + " dx, from " + lowerBound + " to " + upperBound);
        IntegralSolver solver = new IntegralSolver();
        String result = solver.definiteIntegral(lowerBound,upperBound,contents,type);
        System.out.println(result);
        System.out.println("----------------------------------------------------------------\nThank you for using Integral Solver!");
        }
        
    }

    //prints the results of the indefinite integral
    if(deforIndef.toLowerCase().equals("n"))
    {
        System.out.print("Is your equation Exponential, Trig-based, Logarithmic, or a Polynomial?: ");
        String type = scan.nextLine();
        if(!type.toLowerCase().equals("exponential")&&!type.toLowerCase().equals("trig-based")&&!type.toLowerCase().equals("logarithmic")&&!type.toLowerCase().equals("polynomial"))
        {
            System.out.println("Sorry! That's invalid! Please try again.");
        }
        else
        {
        System.out.print("Enter the integrand with respect to \'x\': ");
        String contents = scan.nextLine();
        System.out.println("----------------------------------------------------------------\nInput: Indefinite integral of " + contents + " dx");
        IntegralSolver solver = new IntegralSolver();
        String result = solver.indefiniteIntegral(contents,type);
        System.out.println(result);
        System.out.println("----------------------------------------------------------------\nThank you for using Integral Solver!");
        }
    }
    
    scan.close();
    }
}
