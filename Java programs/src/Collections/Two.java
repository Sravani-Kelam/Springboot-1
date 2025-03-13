package Collections;

import java.util.ArrayList;

public class Two {
    public static void main(String args[]) {
        ArrayList<String> al = new ArrayList<>();
        al.add("hii");
        al.add("hi");
        System.out.println(al);
        ArrayList<String> a2 = new ArrayList<>();
        a2.add("hello");
        a2.add("helo");
        System.out.println(a2);
        a2.addAll(al);

    }
}