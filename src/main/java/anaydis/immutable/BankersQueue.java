package anaydis.immutable;

import org.jetbrains.annotations.NotNull;

public class BankersQueue<T> implements Queue<T> {

    private final List<T> in;
    private final List<T> out;

    public BankersQueue(@NotNull List<T> in, @NotNull List<T> out){
        this.in = in;
        this.out = out;
    }
    public BankersQueue(){
        in = List.nil();
        out = List.nil();
    }



    @NotNull
    @Override
    public Queue<T> enqueue(@NotNull T value) {
        return new BankersQueue<>(List.cons(value,in),out);
    }

    @NotNull
    @Override
    public Result<T> dequeue() {
        if (!out.isEmpty()){
            return new Result<>(out.head(),new BankersQueue<>(in,out.tail()));
        }else {
            List<T> reversed = in.reverse();
            return new Result<>(reversed.head(),new BankersQueue<>(List.nil(),reversed.tail()));
        }
    }

    @Override
    public boolean isEmpty() {
        return (in.isEmpty() && out.isEmpty());
    }
}
