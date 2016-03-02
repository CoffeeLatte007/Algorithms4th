package api;

/**
 * SequentialSearchST 基于无序链表
 * Created by lizhaoz on 2016/1/11.
 */

public class SequentialSearchST<Key,Value>{
    private int N;
    private Node first;//链表的首节点
    private class Node {
        private Key key;//Node的键
        private Value val;//Node的值
        private Node next;//下一个节点

        public Node(Key key, Value val, Node next)  {
            this.key  = key;
            this.val  = val;
            this.next = next;
        }
    }
    public SequentialSearchST() {
    }
    public int size() {
        return N;
    }
    public boolean isEmpty() {
        return size() == 0;
    }
    public boolean contains(Key key) {
        if (key == null) throw new NullPointerException("argument to contains() is null");
        return get(key) != null;
    }
    public Value get(Key key) {
        //从头结点开始遍历，有就返回，没有就返回NULL
        if (key == null) throw new NullPointerException("argument to get() is null");
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key))
                return x.val;
        }
        return null;
    }
    public void put(Key key,Value val){
        //查找给定的键，找到则更新其值，否则在表中新建节点
        for (Node x=first;x!=null;x=x.next)
            if (key.equals(x.key)){
                x.val=val;return;//命中更新
            }
        first=new Node(key,val,first);
        N++;
    }
    public Iterable<Key> keys(){
        Queue<Key> queue=new Queue<Key>();
        for (Node x=first;x!=null;x=x.next){
            queue.enqueue(x.key);
        }
        return queue;
    }
    public void delete(Key key) {
        if (key == null) throw new NullPointerException("argument to delete() is null");
        first = delete(first, key);
    }
    private Node delete(Node x,Key key){
        if (x==null) return null;
        if (key.equals(x.key)){
            N--;
            return x.next;
        }
        x.next = delete(x.next, key);
        return x;
    }
}
