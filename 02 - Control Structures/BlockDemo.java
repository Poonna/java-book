public class BlockDemo {
    public static void main(String[] args) {
        int a = 10;
        double b = 5.25;
        
        System.out.println("Outside of the block");
        
        {
            double c = 15.4;
            
            System.out.println("Inside the block");
            System.out.println("... where a + b = " + (a + b));
        }
        
        for (int a = 0; a < 10; a++) {
            System.out.println("Hey, a is redefined");
        }

        System.out.println("Outside again");
        System.out.println("... where a + b = " + (a + b));
    }
}

