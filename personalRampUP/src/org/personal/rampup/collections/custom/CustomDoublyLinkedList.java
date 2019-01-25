package org.personal.rampup.collections.custom;

public class CustomDoublyLinkedList<E> {
    DoublyLinkedNode<E> head, tail;
    int size;

    public void add(E element) {
        DoublyLinkedNode<E> t = tail;
        DoublyLinkedNode<E> newNode = new DoublyLinkedNode<>(element);
        tail = newNode;
        if (head == null) {
            head = newNode;
        } else {
                t.next = newNode;
                newNode.prev = t;
        }
        size++;
    }

    public void remove(int index) {
        DoublyLinkedNode<E> curNode =head;
//        boolean increase = false;
        int curCount =0;
      /*  if(size/2 < index) {
            curNode = tail;
//            curCount = size;
            increase = false;
            index = size-index+1;
        } else {
            curNode = head;
            increase = true;
        }*/
        while (curCount < index) {
            curNode = curNode.next;
            curCount++;
        }

       /* while (curCount >= index+1){
            curNode = curNode.prev;
            curCount--;
        }*/
       if(curNode.next!= null && curNode.prev != null) {
           DoublyLinkedNode<E> temp = curNode;
           curNode.prev.next = curNode.next;
           curNode.next.prev = curNode.prev;
           temp = null;
       } else if(curNode.prev == null){
           head = curNode.next.prev;
           curNode.next.prev = null;
       } else{
           tail = curNode.prev.next;
           curNode.prev.next= null;

       }


    }

    public void displayList() {
        DoublyLinkedNode<E> curNode = head;
        while (curNode != null) {
            System.out.println(curNode.element);
            curNode = curNode.next;
        }
    }

    public E getFromLast(int index) {
        DoublyLinkedNode<E> curNode = tail;
        int curElement = size;
        while (curElement > index) {
            curNode = curNode.prev;
            curElement--;
        }
        return curNode.element;
    }

    public void printAllFromLast() {
        DoublyLinkedNode<E> curNode = tail;
        int curElement = size;
        while (curElement > 0) {
            System.out.println(curNode.element);
            curNode = curNode.prev;
            curElement--;
        }
    }

}

class DoublyLinkedNode<E> {
    DoublyLinkedNode<E> prev;
    DoublyLinkedNode<E> next;
    E element;

    public DoublyLinkedNode(E element) {
        this.element = element;
    }
}
