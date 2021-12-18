package anaydis.immutable;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class BinaryTree<K, V> implements Map<K, V>{

    private static class Node<K, V>{
        final K key;
        final V value;
        Node<K, V> left, right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public Node(K key, V value, Node<K, V> left, Node<K, V> right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    private class Result{
        Node<K, V> node;
        int size;

        public Result(Node<K, V> node, int size) {
            this.node = node;
            this.size = size;
        }
    }

    private final Node<K, V> head;
    private final int size;
    private final Comparator<K> comparator;

    public BinaryTree(Node<K, V> head, int size, Comparator<K> comparator) {
        this.head = head;
        this.size = size;
        this.comparator = comparator;
    }

    public BinaryTree(Comparator<K> comparator){
        this.head = null;
        this.size = 0;
        this.comparator = comparator;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean containsKey(@NotNull K k) {
        return containsKey(head, k);
    }

    private boolean containsKey(Node<K, V> node, K k) {
        if (node == null) return false;
        final int cmp = comparator.compare(k, node.key);
        if (cmp == 0){
            return true;
        }else if (cmp < 0){
            return containsKey(node.left, k);
        }else{
            return containsKey(node.right, k);
        }
    }

    @Override
    public V get(@NotNull K k) {
        return get(head, k);
    }

    private V get(@Nullable Node<K, V> node, K k) {
        if (node == null) return null;
        final int cmp = comparator.compare(k, node.key);
        if (cmp == 0){
            return node.value;
        }else if (cmp < 0){
            return get(node.left, k);
        }else{
            return get(node.right, k);
        }
    }

    @NotNull
    @Override
    public Map<K, V> put(@NotNull K k, V v) {
        Result result = put(k, v, head);
        return new BinaryTree<>(result.node, result.size, comparator);
    }

    private Result put(K k, V v, Node<K, V> node) {
        if (node == null) {
            return new Result(new Node<>(k, v), size + 1);
        }
        int cmp = comparator.compare(node.key, k);
        if (cmp == 0){
            return new Result(new Node<>(k, v), size);
        }else if (cmp < 0){
            final Result result = put(k, v, node.right);
            return new Result(new Node<>(node.key, node.value, node.left, result.node), result.size);
        }else{
            final Result result = put(k, v, node.left);
            return new Result(new Node<>(node.key, node.value, result.node, node.right), result.size);
        }
    }

    @Nullable
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
