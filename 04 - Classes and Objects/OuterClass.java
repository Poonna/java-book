public class OuterClass {
    public int publicVar = 0;
    private int privateVar = 1;
    
    private class InnerClass {
        public int publicVar = 3;
        private int privateVar = 4;
        
        public void innerClassTest() {
            System.out.println(publicVar);
            System.out.println(privateVar);
            System.out.println(OuterClass.this.privateVar);
            System.out.println(StaticNestedClass.staticClassVar);
        }
    }
    
    public static class StaticNestedClass {
        public static int staticClassVar = 6;
    }
    
    public void outerClassTest() {
        System.out.println(publicVar);
        System.out.println(privateVar);
        
        InnerClass inner = new InnerClass();
        inner.innerClassTest();
    }
    
    public static void main(String[] args) {
        OuterClass top = new OuterClass();
        
        System.out.println(top.publicVar);
        System.out.println(top.privateVar);
        
        top.outerClassTest();
    }
}
