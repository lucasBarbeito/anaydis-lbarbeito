package anaydis.search;

import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Iterator;

public class TSTMap<V> implements Map<String,V>{

    private Node<V> head;
    private int size;

    public TSTMap(){
        head = null;
        size = 0;
    }

    private static class Node<V>{
        char aChar;
        V value = null;
        Node<V> left , middle , right = null;

        private Node(char aChar){
            this.aChar = aChar;
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

    @Override
    public boolean containsKey(@NotNull String key) {
        return find(head,key,0) != null;
    }

    @Override
    public V get(@NotNull String key) {
        Node<V> returningNode = find(head,key,0);
        if (returningNode == null) return null;
        V value = returningNode.value;
        return value;
    }

    private Node<V> find(Node<V> node, String key, int level){
        if (node == null || level >= key.length()) return null;

        if (node.aChar == key.charAt(level)){
            if (key.length() == level + 1) return node;
            else {
               return find(node.middle,key,level+1);
            }
        }else {
            Node next = (key.charAt(level) > node.aChar)? node.right : node.left;
            return find(next,key,level);
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
            Node<V> newNode = new Node<V>(key.charAt(level));
            if (level + 1 < key.length()){
                newNode.middle = put(newNode.middle, key , value , level + 1);
            }else {
                size++;
                newNode.value = value;
            }
            return newNode;

        }else if (node.aChar == key.charAt(level)){
            if (level + 1 == key.length()){
                if (node.value == null){
                    size++;
                }else {
                    node.value = value;
                }
            }else {
                node.middle = put(node.middle, key, value, level + 1);
            }
            return node;
        }else if (node.aChar < key.charAt(level)){
            node.right = put(node.right, key, value, level);
            return node;
        }else {
            node.left = put(node.left, key, value, level);
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
        HashSet<String> set = new HashSet<>();
        keys(head, "", set);
        return set.iterator();
    }

    private void keys( Node node, String key, @NotNull HashSet<String> set) {
        if (node == null)return;
        if (node.value !=  null)set.add(key + node.aChar);
        keys(node.left, key, set);
        keys(node.right, key, set);
        keys(node.middle, key + node.aChar, set);
    }
}
