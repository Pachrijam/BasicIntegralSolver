import java.util.Scanner;
import java.lang.Math;

public class IntegralSolver {

    public double definiteIntegral(double lowerBound, double upperBound, String contents)
    {
        return 0.0;
    }

    public double indefiniteIntegral(String contents)
    {
        return 0.0;
    }

    public static void main(String[] args) throws Exception {
    Scanner scan = new Scanner(System.in);

    System.out.print("Hello! Welcome to Integral Solver!\n---------------------------------------------------------\nEnter \'Y\' for definite integral or \'N\' for indefinite integral: ");
    String deforIndef = scan.nextLine();
    
    if(deforIndef.toLowerCase().equals("y"))
    {
        System.out.print("Enter lower bound: ");
        double lowerBound = scan.nextDouble(); 
        System.out.print("Enter upper bound: ");
        double upperBound = scan.nextDouble();
        scan.nextLine();
        System.out.print("Enter equation with respect to \'x\': ");
        String contents = scan.nextLine();
        
    }
    if(deforIndef.toLowerCase().equals("n"))
    {
        System.out.print("Enter equation with respect to \'x\': ");
        String contents = scan.nextLine();   
    }
    
    scan.close();
    }
}
