package my.extended;

import my.pair.Pair;

public class ExchangeablePair extends Pair {
    public ExchangeablePair(int first, int second) {
        super(first, second);
    }
    
    public void exchangeWith(ExchangeablePair another) {
        int temp;
        
        // Swap values of first
        temp = another.first;
        another.first = first;
        first = temp;
        
        // Swap values of second
        temp = another.second;
        another.second = second;
        second = temp;
    }
}
