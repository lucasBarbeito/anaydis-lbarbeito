package anaydis.search;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RWayTrieMap<V> implements Map<String,V> {

    private Node<V> head;
    private int size;

    public RWayTrieMap(){
        head = null;
        size = 0;
    }

    private static class Node<V> {
        V value;
        Node[] next;

        private Node() {
            value = null;
            next = new Node[256];
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    private Node<V> find(Node<V> node, String key, int level){
        if (node == null) return null;
        if (level == key.length()) return node;
        int next = key.charAt(level);
        return find(node.next[next],key,level+1);
    }

    @Override
    public boolean containsKey(@NotNull String key) {
        return find(head,key,0) != null;
    }

    @Override
    public V get(@NotNull String key) {
        Node<V> returningValue = find(head,key,0);
        if (returningValue == null){
            return null;
        }else {
            return returningValue.value;
        }
    }

    @Override
    public V put(@NotNull String key, V value) {
        V previousValue = get(key);
        head = put(head,key,value,0);
        return previousValue;
    }

    private Node<V> put(Node<V> node, String key, V value, int level){
        if (node == null){
            Node<V> newNode = new Node<V>();
            if (level < key.length()){
                int nextValue = key.charAt(level);
                newNode.next[nextValue] = put(newNode.next[nextValue],key,value,level + 1);
            }else {
                size++;
                newNode.value = value;
            }
            return newNode;
        } else if (level == key.length()){
            node.value = value;
            return node;
        }else {
            int nextValue =  key.charAt(level);
            node.next[nextValue] = put(node.next[nextValue],key,value,level + 1);
            return node;
        }
    }


    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public Iterator<String> keys() {
        List<String> list = new ArrayList<>();
        keys(head, "", list);
        return list.iterator();
    }

    private void keys(Node node, String key, List<String> list) {
        if (node != null){
            if (node.value != null)list.add(key);
            for (int i = 0; i < node.next.length; i++) {
                keys((Node) node.next[i], key + (char) i, list);
            }
        }
    }
}