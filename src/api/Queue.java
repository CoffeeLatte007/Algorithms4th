package api;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * Created by lizhaoz on 2016/1/8.
 */

public class Queue<Item> implements Iterable<Item> {
    private Node<Item> first;
    private Node<Item> last;
    private int N;
    private static class Node<Item>{
        private Item item;
        private Node<Item> next;
    }
    public Queue(){
        first=null;
        last=null;
        N=0;
    }
    public boolean isEmpty(){
        return first==null;
    }
    public int size(){
        return N;
    }
    //弹出
    public Item peek(){
        if (isEmpty())throw new NoSuchElementException("Queue underflow");
        return first.item;
    }
    public void enqueue(Item item){
        Node<Item> node=last;
        last=new Node<Item>();
        last.item=item;
        last.next=null;
        if(isEmpty())first=last;
        else node.next=last;
        N++;
    }
    public Item dequeue(){
        if(isEmpty()) throw new NoSuchElementException("Queue underflow");
        Item item=first.item;
        first=first.next;
        N--;
        if (isEmpty()) last=null;
        return item;
    }
    public String toString(){
        StringBuilder s=new StringBuilder();
        for (Item item:this)
            s.append(item+" ");
        return s.toString();
    }
    public Iterator<Item> iterator()  {
        return new ListIterator<Item>(first);
    }

    // an iterator, doesn't implement remove() since it's optional
    private class ListIterator<Item> implements Iterator<Item> {
        private Node<Item> current;

        public ListIterator(Node<Item> first) {
            current = first;
        }

        public boolean hasNext()  { return current != null;                     }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }


}
