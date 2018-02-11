package extended;

class PairTest {
    public static void main(String[] args) {
        ExchangeablePair a = new ExchangeablePair(1, 2);
        ExchangeablePair b = new ExchangeablePair(3, 4);

        a.exchangeWith(b);
        a.print();
        b.print();
    }
}
