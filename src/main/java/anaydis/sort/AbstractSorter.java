package anaydis.sort;

import anaydis.sort.gui.ObservableSorter;
import anaydis.sort.gui.SorterListener;
import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Abstract sorter: all sorter implementations should subclass this class.
 */
abstract class AbstractSorter implements ObservableSorter {

    private final SorterType type;
    private final Set<SorterListener> listeners;

    AbstractSorter(SorterType type) {
        this.type = type;
        listeners = new HashSet<>();
    }

    public void notifyGreater(int i, int j){
        for (SorterListener listener : listeners) {
            listener.greater(i, j);
        }
    }

    <T> boolean greater(Comparator<T> comparator, List<T> list, int i, int j) {
        notifyGreater(i, j);
        return comparator.compare(list.get(i),list.get(j)) > 0;
    }

    <T> void swap(List<T> list, int i, int j){
        notifySwap(i, j);
        list.set(j, list.set(i, list.get(j)));
    }

    public void notifySwap(int i, int j){
        for (SorterListener listener : listeners) {
            listener.swap(i, j);
        }
    }

    <T> void compSwap(Comparator<T> comparator, List<T> list, int i, int j){
        if (greater(comparator, list, i, j)){
            swap(list, i, j);
        }
    }

    <T> boolean equals(Comparator<T> comparator, List<T> list, int i, int j){
        notifyEquals(i, j);
        return comparator.compare(list.get(i), list.get(j)) == 0;
    }

    public void notifyEquals(int i, int j){
        for (SorterListener listener : listeners) {
            listener.equals(i, j);
        }
    }

    <T> void copy(List<T> list, int i, List<T> list1, int j) {
        notifyCopy(i, j);
        list.set(i, list1.get(j));
    }

    void notifyCopy(int from, int to) {
        for (SorterListener sorterListener : listeners) {
            sorterListener.copy(from, to, true);
        }
    }

    public void addSorterListener(@NotNull SorterListener listener){
        listeners.add(listener);
    }

    public void removeSorterListener(@NotNull SorterListener listener){
        listeners.remove(listener);
    }

    @Override
    public @NotNull SorterType getType(){
        return type;
    }

}
