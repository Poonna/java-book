package extended;

import pair.Pair;

public class SwappablePair extends Pair {
    public SwappablePair(int first, int second) {
        super(first, second);
    }
    
    public void swap() {
        int temp = first;
        first = second;
        second = temp;
    }
}
