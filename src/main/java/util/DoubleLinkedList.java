package util;

import java.util.NoSuchElementException;

/*
 * pretty unnecessary, i just need a data type that can work with
 * recursive double linked list
 * basically a binary search tree but linear
 */
public class DoubleLinkedList{

    private class Node{
        double key;
        double value;
        Node next;
        Node prev;


        Node(double key, double value){
            this.key = key;
            this.value = value;
            next = null;
            prev = null;


        }


    }

    private int size = 0;
    private Node first;

    //put
    public void put(double key, double value){
        if(size == 0){
            size++;
            first = new Node(key, value);
        }
        else put(first, key, value);
    }
    //put if not empty
    public void put (Node n, double key, double value){
        //if current node key is smaller
        if(n.key < key){
            //if next is null
            if(n.next == null){
                n.next = new Node(key, value);
                n.next.prev = n;
            }
            else put(n.next, key, value);
        }
        else if(n.key > key){
            //if value is smaller than first
            if(n == first){
                //sets first's previous
                first.prev = new Node(key, value);
                //sets new nodes next
                first.prev.next = first;
                //sets new node to first
                first = first.prev;
            }
            else {
                Node newN = new Node(key, value);
                //new node next = n
                newN.next = n;
                //new node prev = n.prev
                newN.prev = n.prev;
                //old previous node next set to newnode
                n.prev.next = newN;
                //next node previous set to new node
                n.prev = newN;

            }
        }
        else{
            System.out.println("value already added");
            return;
        }

        size++;
    }

    //get
    public double get(double key){
        return get(first, key);
    }
    public double get(Node n, double key) throws NoSuchElementException{
        //if key is less than current node
        if(n.key < key){
            //if next is null throw error
            if(n.next == null){
                throw new NoSuchElementException();
            }
            //else go next node
            else return get(n.next, key);

        }
        //if value is greater, then throw error
        if(n.key > key){
            throw new NoSuchElementException();
        }
        else {
            return n.value;
        }

    }
}
