import java.util.Scanner;
import java.util.InputMismatchException;

public class DivideByZeroWithExceptionHandling {
    public static int quotient(int numerator, int denominator) {
        return numerator / denominator;
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean keepRetrying = true;
        
        do {
            try {
                System.out.print("Enter an integer numerator: ");
                int numerator = input.nextInt();
                System.out.print("Enter an integer denominator: ");
                int denominator = input.nextInt();

                int result = quotient(numerator, denominator);
                System.out.printf("%d/%d = %d%n", numerator, denominator, result);

                keepRetrying = false;
            } catch (InputMismatchException e) {
                System.err.printf("Exception: %s%n", e);
                System.out.println("You must enter an integer. Please try again.");
                input.nextLine(); // discard the input and try again
            } catch (ArithmeticException e) {
                System.err.printf("Exception: %s%n", e);
                System.out.println("Denominator cannot be zero. Please try again.");
            }
        } while (keepRetrying);

    }
}
