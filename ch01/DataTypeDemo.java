class DataTypeDemo {
    public static void main(String[] args) {
        int a, b;
        double x, y;
        boolean p, q;
        String s;

        a = 10;
        b = 20;
        x = 1.5;
        y = 2.0;

        p = a + b < x * b;
        System.out.printf("%d + %d = %d\n", a, b, a + b);
    }
}
