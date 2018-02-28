public class UsingChainedExceptions {
    public static void main(String[] args) {
        try {
            method1();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void method1() throws Exception {
        try {
            method2();
        } catch (Exception e) {
            throw new Exception("Exception thrown in method1()", e);
        }
    }
    
    public static void method2() throws Exception {
        try {
            method3();
        } catch (Exception e) {
            throw new Exception("Exception thrown in method2()", e);
        }
    }
    
    public static void method3() throws Exception {
        throw new Exception("Exception thrown in method3()");
    }
}
