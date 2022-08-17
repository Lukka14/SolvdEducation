package interfacetask.classes;

import interfacetask.classes.GEL;
import interfacetask.classes.HumanClass;
import interfacetask.classes.TechnoBank1;
import interfacetask.interfaces.Money;

public class Main {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(3,4);
        System.out.println(rectangle);
        System.out.println();


        Square square = new Square();
        square.setA(5);
        System.out.println(square);
        System.out.println();


        TechnoBank1 technobank= new TechnoBank1();
        Money gel100=new GEL(100);

        technobank.depositMoney(gel100);
        technobank.convertCurrency("gel","Usd",70);
        technobank.convertCurrency("usd","rub",10);
        System.out.println(technobank.toString());
        System.out.println();


        GEL money=new GEL(15);
        HumanClass human=new HumanClass("Leanid",1997,51,money);
        System.out.println(human);


    }
}
