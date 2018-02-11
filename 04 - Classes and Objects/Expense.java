import java.time.LocalDateTime;

public class Expense {
    private String item;
    private double amount;
    private LocalDateTime time;

    public Expense(String item, double amount) {
        this.item = item;
        this.amount = amount;
        time = LocalDateTime.now();
    }
    
    public String getItem() {
        return item;
    }
    
    public double getAmount() {
        return amount;
    }
    
    public void print() {
        System.out.printf("%s: %.2f", item, amount);
    }
    
    public static void main(String[] args) {
        Expense item1 = new Expense("Phone bill", 799.00);
        item1.print();
    }
}
