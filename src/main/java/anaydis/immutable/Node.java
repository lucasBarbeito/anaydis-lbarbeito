package anaydis.immutable;


import org.jetbrains.annotations.NotNull;

public class Node<T> implements List<T> {

    private final T element;
    private final List<T> tail;

    public Node(T element, List<T> tail) {
        this.element = element;
        this.tail = tail;
    }

    @Override
    public T head() {
        return element;
    }

    @Override
    public @NotNull List<T> tail() {
        return tail;
    }

    @Override
    public boolean isEmpty() {
        return element == null;
    }

    @Override
    public @NotNull List<T> reverse() {
        List<T> reversed = List.nil();
        List<T> actual = this;
        while(!actual.isEmpty()){
            reversed = List.cons(actual.head(), reversed);
            actual = actual.tail();
        }
        return reversed;
    }
}
