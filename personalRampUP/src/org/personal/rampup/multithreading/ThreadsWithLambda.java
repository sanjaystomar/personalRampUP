package org.personal.rampup.multithreading;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class ThreadsWithLambda {
    public static String stringdata = "sanjay somduti sanjeet suresh saroj reba sapna suraj geet pucchu";
    public static List<String> stringList = Arrays.asList(stringdata.split(" "));

    public static void main(String[] args) {
        method1();


       /* Runnable w1 = () -> System.out.println("Hi I'm running in thread : " + Thread.currentThread().getName());
        Thread t1 = new Thread(w1);
        t1.start();

        new Thread(() -> System.out.println("this is second thread : " + Thread.currentThread().getName())).start();

        Thread t2 = new Thread() {
            @Override
            public void run() {
                System.out.println("This is Anonymous runnable cllas exmaple of thread : " + Thread.currentThread().getName());
            }
        };
        t2.start();*/
    }


    public static void method1() {
    /*    stringList.stream()
                .forEach(System.out::println);*/

        Comparator<String> anonymousComparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        };


        stringList.sort(anonymousComparator);


        Comparator<String> lambdaComparator = (String o1, String o2) -> {
            return o1.compareTo(o2);
        };
        Comparator<String> lambdaComparator1 = (String o1, String o2) -> o1.compareTo(o2);

        Comparator<String> lambdaComparator2 = (o1, o2) -> o1.length()- o2.length();

// one line code no need of return keyword

      /*  System.out.println("====================");
        stringList.sort(lambdaComparator2);
        System.out.println(stringList);*/

        stringList.sort((e1, e2) -> e2.compareTo(e1));
        System.out.println(stringList);


        Consumer<String> stringConsumer = (String e) -> System.out.println(e);
        Supplier<String> stringSupplier = () -> new String("shivam");
        Predicate<String> stringPredicate = (String e1) -> e1.length()%2 == 0? true:false;
        Function<String, Integer> stringIntegerFunction = (String e1) -> e1.length()*5;



        stringList.stream()
                .filter(stringPredicate)
                .map(stringIntegerFunction)
                // .peek(System.out::println)
                .filter(e -> e >20)
                .forEach(System.out::println);
//                .forEach(stringConsumer);

    }
}

