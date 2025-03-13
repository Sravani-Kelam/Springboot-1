package Collections;

import java.util.ArrayList;

public class Arraylist {
    public static void main(String args[]){
        ArrayList<String> a=new ArrayList<>();
        a.add("dog is an animal");
        System.out.println(a);
        ArrayList<String> b=new ArrayList<>();
        b.add("dog lives near my house");
        System.out.println(b);
        b.addAll(a);
    }
}
