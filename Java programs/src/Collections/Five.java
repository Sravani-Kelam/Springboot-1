package Collections;

import java.util.LinkedList;

public class Five {
    public static void main(String args[]){
        LinkedList <String> Employee=new LinkedList<>();
        Employee.add("sri");
        Employee.add("ajju");
        Employee.add("siri");
        Employee.add("avi");
        System.out.println("LinkedList:"+Employee);
        Employee.add(3,"raju");
        System.out.println("update:"+Employee);
        Employee.remove(2);
        System.out.println("remove:"+Employee);
        Employee.sort(null);
        System.out.println("sort:"+Employee);
        Employee.push("keerthi");
        System.out.println("push:"+Employee);
    }
}
