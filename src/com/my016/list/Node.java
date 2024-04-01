package com.my016.list;

import java.util.Objects;

public class Node<T>{
    public T item;
    public Node<T> next ;

    public Node(T item, Node<T> next){
        this.item = item;
        this.next = next;
    }

    public Node(){

    }

    public Node(T[] t){
        Node<T> p = this;
        for (int i = 0; i < t.length; i++) {
            assert p != null;
            p.item = t[i];
            p.next = i < t.length -1 ? new Node<>() : null ;
            p = p.next;
        }
    }

    @Override
    public String toString() {
        return "{" +
                forNode() +
                '}';
    }

    private String forNode(){
        if (item==null){
            return null;
        }
        StringBuilder stringBuffer = new StringBuilder();
        Node<T> p = this;
        while (p.next!=null){
            stringBuffer.append(p.item.toString()).append(",");
            p=p.next;
        }
        stringBuffer.append(p.item.toString());
        return stringBuffer.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node<?> node = (Node<?>) o;
        return Objects.equals(item, node.item) && Objects.equals(next, node.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(item, next);
    }

}
