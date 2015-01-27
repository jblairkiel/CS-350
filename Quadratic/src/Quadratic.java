import java.util.Scanner; // program uses class Scanner

public class Quadratic {

	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);  

		System.out.print("Enter the quadratic coefficiet(a): ");  
		double a = input.nextDouble();  

		System.out.print("Enter the linear coefficnet(b): ");  
		double b = input.nextDouble();  

		System.out.print("Enter the constant term(c): ");  
		double c = input.nextDouble();  

		double discriminant = b*b-4*a*c;  

		double x1 = (-b+Math.sqrt(discriminant))/(2*a);  
		double x2 = (-b-Math.sqrt(discriminant))/(2*a);  

		System.out.println("Two roots are " + x1 + " and " + x2);  
	}
}
