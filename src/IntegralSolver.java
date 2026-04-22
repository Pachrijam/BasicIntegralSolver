import java.util.Scanner;

public class IntegralSolver {
    //computes def. integral
    public String definiteIntegral(double lowerBound, double upperBound, String contents, String type)
    {
        double c = 1;
        double k = 1;
        
        //EQUAL BOUNDS
        if(lowerBound == upperBound)
        {
            return "Output: 0";
        }

        //CONSTANT INTEGRATION
        if(type.toLowerCase().equals("c")){
            double numConstant = Double.parseDouble(contents);
            double constantSum = numConstant*upperBound - numConstant*lowerBound;
            return "Output: " + constantSum;
        }
        
        if(type.toLowerCase().equals("e")){}
        if(type.toLowerCase().equals("t")){}
        if(type.toLowerCase().equals("l")){}
        if(type.toLowerCase().equals("p")){}
    
        return "Output: ";
    }
    //computes indef. integral
    public String indefiniteIntegral(String contents, String type)
    {
        //INITIALIZED CONSTANT VARIABLES
        double c = 1.0;
        double k = 1.0;
        int n = 1;
        
        contents = contents.replace(" ", "");
        
        //EXPONENTIAL CALCULATION
        if(type.toLowerCase().equals("e")){
            
            //CHECK FOR e^x
            if(contents.equals("e^x")){return "Output: e^x + C";}
            //GENERAL CASE
            if(contents.matches("[-]?\\d*\\.?\\d*e\\^\\([-]?\\d*\\.?\\d*x\\)")){
            int eIndex = contents.indexOf("e");
            //EXTRACT OUTER COEFFICIENT (C)
            if(eIndex > 0){
            String coeffStr = contents.substring(0, eIndex);
            if(coeffStr.equals("-")) c = -1;
            else if(!coeffStr.equals("")) c = Double.parseDouble(coeffStr);
        }

        //EXTRACT INNER COEFFICIENT (K)
        int start = contents.indexOf("(") + 1;
        int end = contents.indexOf("x");

        String kStr = contents.substring(start, end);

        if(kStr.equals("") || kStr.equals("+")) k = 1;
        else if(kStr.equals("-")) k = -1;
        else k = Double.parseDouble(kStr);

        double newCoeff = c / k;
        return "Output: " + newCoeff + "e^(" + k + "x) + C";
    }
        
        }

        //CONSTANT CALCULATION
        if(type.toLowerCase().equals("c")){
            return "Output: " + contents + "x + C";     
        }

        //TRIG BASED CALCULATION

        if(type.toLowerCase().equals("t")){
        }

        //LOGARITHMIC CALCULATION

        if(type.toLowerCase().equals("l")){
            
            if(contents.matches("[-]?\\d*\\.?\\d*ln\\([-]?\\d*\\.?\\d*x\\)")){
            int lIndex = contents.indexOf("l");
            //EXTRACT OUTER COEFFICIENT (C)
            if(lIndex > 0)
                {
                String coeffStr = contents.substring(0,lIndex);
                if(coeffStr.equals("-")) c =-1;
                else if(!coeffStr.equals("")) c = Double.parseDouble(coeffStr);
                }
            //EXTRACT INNER COEFFICIENT (K)
            int start = contents.indexOf("(") + 1;
            int end = contents.indexOf("x");
            String kString = contents.substring(start,end);
            if(kString.equals("")|| kString.equals("+")) k = 1;
            else if(kString.equals("-")) k = -1;
            else k = Double.parseDouble(kString);
            
            //RETURN
            return "Output: " + c + "xln(" + k + ") - " + c + "x + C"; 
            }
            if(contents.equals("ln(x)")){return "Output: xln(x) - x + C";}
            return "Output: Unsupported logarithmic input.";
        }

        //POLYNOMIAL CALCULATION

        if(type.toLowerCase().equals("p")){
        //SPECIAL CASE
        if(contents.equals("x")){return "Output: (1/2)x^2 + C";}
        //GENERAL CASE
        if(contents.matches("[-]?\\d*\\.?\\d*x\\^\\([-]?\\d+\\)")){
        int pIndex = contents.indexOf("x");
        //EXTRACT OUTER COEFFICIENT (C)
        if(pIndex > 0)
            {
            String coeffStr = contents.substring(0,pIndex);
            if(coeffStr.equals("-")) c = -1;
            else if(!coeffStr.equals("")) c = Double.parseDouble(coeffStr);
            }
        //EXTRACT INNER COEFFICIENT
        int start = contents.indexOf("(") + 1;
        int end = contents.indexOf(")");

        n = Integer.parseInt(contents.substring(start, end));
        //POWER RULE
        int newPower = n+1;
        double newCoeff = c/newPower;

        //RETURN
        String coeffOut = (newCoeff == (int)newCoeff)
                ? String.valueOf((int)newCoeff)
                : String.valueOf(newCoeff);

        return "Output: " + coeffOut + "x^" + newPower + " + C";
        }
        return "Output: Unsupported polynomial input.";
        }

        return "Invalid. Please try again.";
    }
    //MAIN       
    public static void main(String[] args) throws Exception {
    
    Scanner scan = new Scanner(System.in);
    System.out.print("Hello! Welcome to Integral Solver!\n----------------------------------------------------------------\nEnter \'Y\' for definite integral or \'N\' for indefinite integral: ");
    String deforIndef = scan.nextLine();
    

    //prints results of the definite integral
    if(deforIndef.toLowerCase().equals("y"))
    {
        System.out.print("Is your equation Exponential (e), Trig-based (t), Logarithmic (l), Polynomial (p), or a Constant (c) ?: ");
        String type = scan.nextLine();
        if(!type.toLowerCase().equals("e")&&!type.toLowerCase().equals("t")&&!type.toLowerCase().equals("l")&&!type.toLowerCase().equals("p")&&!type.toLowerCase().equals("c"))
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
        System.out.print("Is your equation Exponential (e), Trig-based (t), Logarithmic (l), Polynomial (p), or a Constant (c) ?: ");
        String type = scan.nextLine();
        if(!type.toLowerCase().equals("e")&&!type.toLowerCase().equals("t")&&!type.toLowerCase().equals("l")&&!type.toLowerCase().equals("p")&&!type.toLowerCase().equals("c"))
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
