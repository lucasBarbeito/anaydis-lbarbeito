package anaydis.search;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class RandomizedTreeMap<K, V> implements Map<K, V> {

    private static class Node<K, V>{

        K key;
        V value;
        Node<K, V> right, left;

        private Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    @Nullable
    private Node<K, V> head;
    private final Comparator<K> comparator;
    private int size;
    private final double prob;

    public RandomizedTreeMap(Comparator<K> comparator) {
        this.comparator = comparator;
        //this.head = null;
        prob = 0.5;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean containsKey(@NotNull K key) {
        return find(head, key) != null;
    }

    @Nullable
    @Override
    public V get(@NotNull K key) {
        return find(head, key);
    }

    @Nullable
    private V find(@Nullable Node<K, V> node, K key) {
        if (node == null) return null;
        final int cmp = comparator.compare(key, node.key);
        if (cmp == 0){
            return node.value;
        }else if (cmp < 0){
            return find(node.left, key);
        }else{
            return find(node.right, key);
        }
    }

    @Override
    public V put(@NotNull K key, V value) {
        V v = get(key);
        if (Math.random() <= prob){
            head = rootPut(head, key, value);
        }else {
            head = put(head, key, value);
        }
        return v;
    }

    private Node<K, V> rootPut(Node<K, V> node, K key, V value) {
        if (node == null){
            size++;
            return new Node<>(key, value);
        }
        int cmp = comparator.compare(key, node.key);
        if (cmp < 0){
            node.left = rootPut(node.left, key, value);
            return rotateRight(node);
        }else if (cmp > 0){
            node.right = rootPut(node.right, key, value);
            return rotateLeft(node);
        }else{
            node.value = value;
            return node;
        }
    }

    private Node<K, V> rotateLeft(Node<K, V> node) {
        if (node.right == null) return node;
        Node<K, V> result = node.right;
        node.right = result.left;
        result.left = node;
        return result;
    }

    private Node<K, V> rotateRight(Node<K, V> node) {
        if (node.left == null) return node;
        Node<K, V> result = node.left;
        node.left = result.right;
        result.right = node;
        return result;
    }

    private Node<K, V> put(Node<K, V> node, K key, V value) {
        if (node == null){
            size++;
            return new Node<>(key, value);
        }
        final int cmp = comparator.compare(key, node.key);
        if (cmp < 0){
            node.left = put(node.left, key, value);
        }else if (cmp > 0){
            node.right = put(node.right, key, value);
        }else{
            node.value = value;
        }
        return node;
    }

    @Override
    public void clear() {
        this.head = null;
        size = 0;
    }

    @Override
    public Iterator<K> keys() {
        List<K> list = new ArrayList<>();
        inorder(head, list);
        return list.iterator();
    }

    private void inorder(Node<K, V> head, List<K> list) {
        if (head != null){
            inorder(head.left, list);
            list.add(head.key);
            inorder(head.right, list);
        }
    }
}
