package org.personal.rampup.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class LoadChildToParent {

    public static void main(String[] args) {
        List<GrandParent> listGrandParent = new ArrayList<>();
        List<Parent> listParent = Arrays.asList(new Parent("ram"), new Parent("shyam"), new Parent("ravi"), new Parent("ganesh"), new Child("Ramesh"));
        List<? extends GrandParent> childList = Arrays.asList(new Parent("hema"), new Child("Baccha"), new GrandSon("munna"));
//        childList = new ArrayList<Parent>();
        List<? super GrandParent> grandParentList = Arrays.asList(new Parent("hema"), new Child("Baccha"), new GrandSon("munna"), new GreatGrandParent("dadaji"));

        List<? super Child> grandSonList = new ArrayList<>();
        grandSonList.add(new GrandSon("shama"));
        grandSonList.add(new Child("rama"));
        grandSonList.add(new GrandSon("sharma"));

        for (Object cha : grandSonList) {
            System.out.println(cha);
        }
//        grandParentList = new ArrayList<GrandParent>();

//        List<? extends  Parent> testExtends = new ArrayList<>();
//        testExtends.add(new Parent("papa"));
//        testExtends.add(new Child("baccha"));

        /**
         * ? extends put a  UPPER BOUND for the elements which can be added to the list but ? super allows everything just above example?????
         */
//        List<? extends GrandParent> childList  =Arrays.asList(new GreatGrandParent("Baccha"));

        grandParentList
                .stream()
                .forEach(System.out::println);


//        merge(listGrandParent, listParent)
//                .stream()
//                .forEach(System.out::println);
    }

/*    public static <S, T extends Parent> List<T>  merge(List<T> target, List<S> source){
        return null;

    }*/

    public static List<? super GrandParent> merge(List<? super GrandParent> target, List<? extends Parent> source) {
        for (Parent curElement : source) {
            target.add(curElement);
        }


        return target;
    }

    public static <T extends GreatGrandParent, M extends Parent> void mergeNonCollection(T arg1, M arg2) {

    }

    /*public static <T,N> List<T> methodName(<T extends Parent> arg1, <N super Parent> arg2){

    }*/


}


class GreatGrandParent {
    protected String name;

    public GreatGrandParent(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "GreatGrandParent{" +
                "name='" + name + '\'' +
                '}';
    }
}

class GrandParent extends GreatGrandParent {
    public GrandParent(String name) {
        super(name);
    }
}

class Parent extends GrandParent {
    public Parent(String name) {
        super(name);
    }
}

class Child extends Parent {
    public Child(String name) {
        super(name);
    }
}

class GrandSon extends Child {
    public GrandSon(String name) {
        super(name);
    }
}
