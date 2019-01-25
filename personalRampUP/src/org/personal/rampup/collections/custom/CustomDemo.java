package org.personal.rampup.collections.custom;

public class CustomDemo {


    public static void main(String[] args) {
//        customSinglyLinkedListUsage();
        customDoublyLinkedListUsage();

    }

    private static void customSinglyLinkedListUsage() {
        CustomSinglyLinkedList<String> customList = new CustomSinglyLinkedList<>();
        customList.add("sanjay");
        customList.add("singh");
        customList.add("tomar");
        customList.add("fun");
        customList.add("run");
        customList.displayCustomList();
        customList.remove(3);
        System.out.println(customList.getElement(2));
    }

    private static void customDoublyLinkedListUsage() {
        CustomDoublyLinkedList<String> customList = new CustomDoublyLinkedList<>();
        customList.add("sanjay");
        customList.add("singh");
        customList.add("tomar");
        customList.add("fun");
        customList.add("run");
        customList.displayList();
        customList.printAllFromLast();
        customList.remove(2);
        System.out.println("=============");
        customList.displayList();
    }

}
