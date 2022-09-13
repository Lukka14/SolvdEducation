package lambda;

import lambda.mynterfaces.ICode;
import lambda.mynterfaces.IGetMessage;
import lambda.mynterfaces.ISumTwoNumbers;

import java.util.LinkedList;
import java.util.function.Consumer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaMain{

    public static void main(String[] args) {

        // void lambda function
        Consumer<String> consumer = (arg) -> System.out.println(arg);
        consumer.accept("text using lambda function");

        // print array elements using lambda function
        List<String> list = new ArrayList<>();
        list.add("get");
        list.add("array");
        list.add("elements");
        list.add("with");
        list.add("lambda");
        list.add("expression");
        list.forEach( (str) -> System.out.println(str) );

        // lambda function inside stream filter
        List<Integer> numbers = new LinkedList<>();
        for(int i=0; i<20; i++)  numbers.add((int) (Math.random()*100));

        List<Integer> smallNumbers = numbers.stream().filter( (n) -> n<10).collect(Collectors.toList());
        System.out.println(smallNumbers);

        // one parameter lambda function
        IGetMessage message = (msg) -> msg.toUpperCase();
        System.out.println(message.getMessage("uppercase message"));

        // multiple parameter lambda function
        ISumTwoNumbers sum = (num1,num2) -> num1+num2;
        System.out.println(sum.sumTwoNumbers(5,6));

        // no parameter lambda fucntion
        ICode code = () -> "4751bh17";
        System.out.println(code.getCode());
    }

}
