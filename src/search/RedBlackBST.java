package search;

import java.util.HashMap;

/**
 * Created by lizhaoz on 2016/1/12.
 */

public class RedBlackBST<Key extends Comparable<Key>,Value> {
    private static final boolean RED=true;
    private static final boolean BLACK=false;
    private Node root;
    private class Node{
        Key key;//键
        Value val;//相关联的值
        Node left,right;//左右子树
        int N;//这棵子树中的结点总数
        boolean color;//由其父节点指向它的连接的颜色

        public Node(Key key, Value val, int n, boolean color) {
            this.key = key;
            this.val = val;
            N = n;
            this.color = color;
        }
    }
    private boolean isRed(Node x){
        if (x==null){
            return false;
        }
        return x.color==RED;
    }
    /*
      左旋
     */
    Node rotateLeft(Node h){
        Node x=h.right;//把h的右边赋值给x,左旋把右结点变为根
        h.right=x.left;//把X的左边给h
        x.left=h;//把h变为x的左边
        x.color=h.color;//把h之前的颜色赋值给x
        h.color=RED;//把h结点变红色
        x.N=h.N;//此时x的结点个数和h一样
        h.N=1+size(h.left)+size(h.right);//h的结点个数需要重新计算
        return x;//返回根
    }
    /*
      右旋
     */
    Node rotateRight(Node h){
        Node x=h.left;//把h的左边赋值给x,右旋把左结点变为根
        h.left=x.right;//把X的右边给h
        x.right=h;//把h变为x的右边
        x.color=h.color;//把h之前的颜色赋值给x
        h.color=RED;//把h结点变红色
        x.N=h.N;//此时x的结点个数和h一样
        h.N=1+size(h.left)+size(h.right);//h的结点个数需要重新计算
        return x;//返回根
    }
    /*
     *双红子节点颜色变换,自己变为红色
     */
    void flipColors(Node h){
        h.color=RED;
        h.left.color=BLACK;
        h.right.color=BLACK;
    }
    private int size(Node node) {
        if (node==null)return 0;
        return node.N;
    }
    public void put(Key key,Value val){
        //查找key,找到则更新其值，否则为它创建一个结点
        root=put(root,key,val);
        root.color=BLACK;//根结点必须为BLACK
    }

    private Node put(Node h, Key key, Value val) {
        if (h==null)//标准的插入操作，和父节点用红链接相连
            return new Node(key,val,1,RED);
        int cmp=key.compareTo(h.key);//判断此node和Key的大小比较

        if (cmp<0) h.left=put(h.left,key,val);//如果node<key 找左边
        else if (cmp>0) h.right=put(h.right,key,val);//node>key 找右边
        else h.val=val;//如果Node=key 直接更新
        //调整，递增,注意顺序不能换，
        if (isRed(h.right)&&!isRed(h.left)) h=rotateLeft(h);//左链接为黑，右链接为红，左旋
        if (isRed(h.left)&&isRed(h.left.left)) h=rotateRight(h);//左链接为红，左链接的左链接也为红，右旋
        if (isRed(h.left)&&isRed(h.right)) flipColors(h);//左右都为红
        h.N=size(h.left)+size(h.right)+1;
        return h;
    }

}
