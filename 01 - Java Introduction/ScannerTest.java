import java.util.Scanner;

public class ScannerTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int n = input.nextInt();
        System.out.print("Enter a floating-point number: ");
        double x = input.nextDouble();
        System.out.print("Enter a few words: ");
        String firstWord = input.next();
        String rest = input.nextLine();

        System.out.println("n = " + n);
        System.out.println("x = " + x);
        System.out.println("The first word = " + firstWord);
        System.out.println("The rest of line = " + rest);
        System.out.println("That's all!");
    }
}
