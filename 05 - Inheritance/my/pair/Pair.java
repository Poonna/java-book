package my.pair;

public class Pair {
    protected int first;
    protected int second;
    
    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
    
    public int getFirst() {
        return first;
    }
    
    public int getSecond() {
        return second;
    }
    
    public void print() {
        System.out.println("(" + first + ", " + second + ")");
    }
}
