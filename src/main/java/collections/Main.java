package collections;


//Homework:
//Add 5 collections to the hierarchy.
//Create custom LinkedList with generic.

import collections.mycollections.MyLinkedList;

import java.util.*;

public class Main {
    public static void main(String[] args){
        List<String> arrayList=new ArrayList<>();
        arrayList.add("John");
        arrayList.add("Lisa");
        arrayList.add("Pablo");
        Main.display(arrayList);

        List<Integer> linkedList=new LinkedList<>();
        linkedList.add(4);
        linkedList.add(45);
        linkedList.add(14);
        Main.display(linkedList);

        List<Double> vector=new Vector<>();
        vector.add(1.7);
        vector.add(1.3);
        vector.add(4d);
        Main.display(vector);
        System.out.println("work");

        List<Boolean> stack=new Stack<>();
        stack.add(0,true);
        stack.add(1,false);
        stack.add(2,false);
        Main.display(stack);

        Set<Character> hashset=new HashSet<>();
        hashset.add('a');
        hashset.add('d');
        hashset.add('e');
        Main.display(hashset);


        MyLinkedList<String> csl = new MyLinkedList<String>();
        csl.addFirst("Java");
        csl.addFirst("Core");
        csl.addLast("is");
        csl.addLast("Great");
        System.out.println(csl);


        MyLinkedList<Integer> cslI = new MyLinkedList<Integer>();
        cslI.addFirst(100);
        cslI.addFirst(200);
        cslI.addFirst(300);
        cslI.addFirst(400);
        cslI.addLast(50);
        cslI.addLast(40);
        cslI.addLast(30);
        System.out.println(cslI.getSize());
        System.out.println(cslI);

        MyLinkedList i = new MyLinkedList();
        i.addFirst('a');
        i.addFirst("abc");
        i.addFirst(123);
        i.addLast(12.34);
        System.out.println(i);
    }

    public static <T> void display(Collection<T> list){
        for(var element: list){
            System.out.println(element);
        }
    }


}
