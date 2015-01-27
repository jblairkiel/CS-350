package practice1;

public class HelloWorld {
	
	public static void main(String args []) {
		
		String helloString;
		Integer num1;
		num1 = 3;
		helloString = "Hello World";
		
		for(int num2 = 1; num2 < 10; num2 = num2 + 1){
			System.out.println(num2 + " | " + helloString + " " + num1);
		}
		
	}

}
