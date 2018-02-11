package extended;

import pair.Pair;

class PairUser {
    public static void main(String[] args) {
        Pair a = new Pair(1, 2);
        SwappablePair b = new SwappablePair(3, 4);

        System.out.println(a.first + a.second); // OK if in the same package, FAILED otherwise
        System.out.println(b.first + b.second); // OK if in the same package, FAILED otherwise

        b.swap(); // OK
        b.print(); // OK
    }
}
