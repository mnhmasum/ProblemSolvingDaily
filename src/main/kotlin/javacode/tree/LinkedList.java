package javacode.tree;


class N {
    int val = 0;
    N next = null;
}

public class LinkedList {
    public static void main(String[] args) {
        N n1 = new N();
        n1.val = 1;

        N n2 = new N();
        n2.val = 2;

        n1.next = n2;

        N h = n1;

        System.out.println("Address n1 " + n1.hashCode());
        System.out.println("Address h " + h.hashCode());

        while(n1 !=null) {
            System.out.println(n1.val);
            n1 = n1.next;
        }

        while(h !=null) {
            System.out.println(h.val);
            h = h.next;
        }

//        System.out.println("Address h " + h.hashCode());
//        System.out.println("Address n1 " + n1.hashCode());


    }
}
