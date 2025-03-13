package Collections;

public class B {
    public static void main(String[] args) {
        for (int i = 0; i <= 100; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("ABCD");
            } else if (i % 3 == 0) {
                System.out.println("three");
            } else {
                System.out.println("five");
            }
        }
    }
}








