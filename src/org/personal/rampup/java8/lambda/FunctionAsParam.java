package org.personal.rampup.java8.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class FunctionAsParam {

    static List<String> friendList = Arrays.asList("Ram", "Shyam", "Ravi", "Arjun", "Tej", "Bhupen");
    static List<String> buyerList = Arrays.asList("Ramanand", "Shyamlal", "Reena", "Arvind", "Timlee", "Bronowick");
    static List<String> sellerList = Arrays.asList("Rakesh", "Shiela", "Rob", "Ascott", "Leela");


    public static void main(String[] args) {

        FunctionAsParam functionAsParam = new FunctionAsParam();
        functionAsParam.filterListByNameFirstLetter();


    }

    private void filterListByNameFirstLetter() {
        Stream<String> r = friendList
                .stream()
                .filter(name -> name.startsWith("R"));
        buyerList
                .stream()
                .filter(name -> name.startsWith("S"));

        sellerList
                .stream()
                .filter(name -> name.startsWith("A"));

        r.forEach(System.out::println);


        final Predicate<String> nameWithA = name -> name.startsWith("A");
        final Predicate<String> nameWithR = name -> name.startsWith("R");

        sellerList
                .stream()
                .filter(nameWithA);

        buyerList
                .stream()
                .filter(nameWithR);

        friendList
                .stream()
                .filter(getPredicate("B"));

        Stream<String> b = buyerList
                .stream()
                .filter(startWithLetter.apply("B"));

        b.forEach(System.out::println);

        System.out.println("++++");
        System.out.println(findFirstWithFirstLetter(buyerList,"R"));


        //Map to int function of stream::
        System.out.println("++++");
        System.out.println("the total number of characters in the provided list : " + buyerList
        .stream()
        .mapToInt(e->e.length())
        .sum());
    }

    static Predicate<String> getPredicate(String letter){
        return name -> name.startsWith(letter);
    }

   /* final Function<String, Predicate<String>> startWithLetter =
        letter -> {
                Predicate<String> letterStart = name -> name.startsWith(letter);
            return letterStart;
    };*/

//    or

    final Function<String, Predicate<String>> startWithLetter =
            letter -> name -> name.startsWith(letter);

    String findFirstWithFirstLetter (List<String> inputList, String letter){
        Optional<String> b = inputList
                .stream()
                .filter(startWithLetter.apply(letter))
                .findFirst();
        b.ifPresent(System.out::println);

        return b.orElse("empty!!");


    }






}
