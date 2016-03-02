package api;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by lizhaoz on 2016/1/8.
 */

public class Stack<Item> implements Iterable<Item>  {
    private Node<Item> first;
    private int N;
    private static class Node<Item>{
       private Item item;
       private Node<Item> next;
    }

    public Stack() {
        N = 0;
        this.first = null;
    }
    public boolean isEmpty(){
        return first==null;
    }
    public int size(){
        return N;
    }
    public void push(Item item){
        Node<Item> oldfirst=first;
        first=new Node<Item>();
        first.item=item;
        first.next=oldfirst;
    }
    public Item pop(){
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        Item item=first.item;
        first=first.next;
        N--;
        return item;
    }
    public Item peek(){
        if (isEmpty()) throw new NoSuchElementException();
        return first.item;
    }
    public String toString(){
        StringBuilder s=new StringBuilder();
        for(Item item:this){
            s.append(item+" ");
        }
        return s.toString();
    }
    @Override
    public Iterator<Item> iterator() {
        return null;
    }
    private class ListIterator<Item> implements Iterator<Item>{
        private Node<Item> current;

        public ListIterator(Node<Item> current) {
            this.current = current;
        }

        @Override
        public boolean hasNext() {
            return current!=null;
        }

        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item=current.item;
            current=current.next;
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

}
