package anaydis.sort.listener;

import anaydis.sort.BenchMark.BenchResult;
import anaydis.sort.gui.SorterListener;

public class OrderSorterListener implements SorterListener {
    private int sw;
    private int gr;
    private int eq;
    private long start;

    public OrderSorterListener() {
        eq = 0;
        gr = 0;
        sw = 0;
        start = 0;
    }


    @Override
    public void box(int from, int to) {

    }

    @Override
    public void copy(int from, int to, boolean copyToAux) {

    }

    @Override
    public void equals(int i, int j) {
        eq++;
    }

    @Override
    public void greater(int i, int j) {
        gr++;
    }

    @Override
    public void swap(int i, int j) {
        sw++;
    }

    public int totalOrder(){
        return sw + gr + eq;
    }

    @Override
    public String toString() {
        return "OrderSorterListener{" +
                "sw=" + sw +
                ", gr=" + gr +
                ", eq=" + eq +
                '}';
    }

    public BenchResult stop() {

        return new BenchResult(System.nanoTime() - start, totalOrder());
    }

    public void begin() {
        start = System.nanoTime();
    }
}