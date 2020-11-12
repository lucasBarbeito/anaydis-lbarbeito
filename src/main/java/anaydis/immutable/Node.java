package anaydis.immutable;

import org.jetbrains.annotations.NotNull;

public class Node<T> implements List<T> {

    private final T head;
    private final List<T> tail;

    public Node(@NotNull T head,@NotNull List<T> tail){
        this.head = head;
        this.tail = tail;
    }

    public Node(){
        head = null;
        tail = List.nil();
    }


    @Override
    public T head() {
        return head;
    }

    @NotNull
    @Override
    public List<T> tail() {
        return tail;
    }

    @Override
    public boolean isEmpty() {
        return (head == null);
    }

    @NotNull
    @Override
    public List<T> reverse() {
        List<T> reversed = new Node<T>();
        List<T> editableList = new Node<T>(head,tail); // podria poner this y es lo mismo

        while (editableList.isEmpty()){
            reversed = List.cons(editableList.head(),reversed);
            editableList = editableList.tail();
        }
        return reversed;
    }
}
