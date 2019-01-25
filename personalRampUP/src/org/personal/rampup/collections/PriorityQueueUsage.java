package org.personal.rampup.collections;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueUsage {

    public static void main(String[] args) {
        Queue<Integer> priorityQueue = new PriorityQueue<>(Integer::compareTo);
        priorityQueue.add(4);
        priorityQueue.add(5);
        priorityQueue.add(6);
        priorityQueue.add(9);
        priorityQueue.add(7);
        priorityQueue.add(3);
        priorityQueue.add(8);
        priorityQueue.add(5);




        Queue<String> priorityQueueStr = new PriorityQueue<>((e1,e2)-> e1.split("-")[0].compareTo(e2.split("-")[0]));
        priorityQueueStr.add("abc-1");
        priorityQueueStr.add("sanjay-1");
        priorityQueueStr.add("fun-1");
        priorityQueueStr.add("run-2");
        priorityQueueStr.add("alarm-1");
        priorityQueueStr.add("run-1");
        priorityQueueStr.add("alarm-2");
        priorityQueueStr.add("sanjay-2");
        priorityQueueStr.add("abc-2");
        System.out.println(priorityQueueStr.size());
//        priorityQueueStr.stream().forEach( e -> System.out.println(e));
        System.out.println("===========");
        priorityQueueStr.poll();
        priorityQueueStr.poll();
        priorityQueueStr.poll();
        System.out.println(priorityQueueStr.size());
        priorityQueueStr.add("run-36");
        System.out.println(priorityQueueStr.size());
//       priorityQueueStr.stream().forEach( e -> System.out.println(e));
        Iterator<String> it =priorityQueueStr.iterator();
        while(it.hasNext())
//        for(int i =0; i< priorityQueueStr.size(); i++){
            System.out.println(priorityQueueStr.poll());
//        }
    }
}
