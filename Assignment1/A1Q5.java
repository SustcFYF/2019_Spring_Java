import java.util.Scanner;
public class A1Q5 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int num1,num2,sum;
        boolean b=true;
        while (b) {
            System.out.print("Enter the first number: ");
            num1=input.nextInt();
            System.out.print("Enter the second number: ");
            num2=input.nextInt();
            sum=num1+num2;
            if (sum==100) {
                b=false;
                System.out.println("Sum of two numbers is 100");
                System.out.println("Sum equals 100, loop terminates");
            } else {
                System.out.printf("Sum of two numbers is %d\n", sum);
                System.out.println("Sum does not equal 100, loop repeats");
            }
        }
    }
}
