package Collections;

import java.util.ArrayList;

public class Three {
    public static void main(String args[]){
        ArrayList<String> al = new ArrayList<>();
        al.add(0,"hii");
        al.add("hi");
        System.out.println(al);
        ArrayList<String> a2 = new ArrayList<>();
        a2.add("hello");
        a2.add("fghj");
        System.out.println(a2);
        a2.addAll(0,a2);

    }
}
