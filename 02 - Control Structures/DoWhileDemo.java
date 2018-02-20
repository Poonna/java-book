import java.util.Scanner;
import java.util.Random;

public class DoWhileDemo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        int secretValue = random.nextInt(9) + 1;
        int guess;
        
        do {
            System.out.print("Enter a number between 1 to 9: ");
            guess = input.nextInt();
            if (guess < secretValue) {
                System.out.println("Too low!");
            } else if (guess > secretValue) {
                System.out.println("Too high!");
            }
        } while (guess != secretValue);
        
        System.out.println("You've got it!");
    }
}
