package anaydis.sort;

import anaydis.sort.gui.ObservableSorter;
import anaydis.sort.gui.SorterListener;
import org.jetbrains.annotations.NotNull;

import java.util.*;

/**
 * Abstract sorter: all sorter implementations should subclass this class.
 */

 abstract class AbstractSorter implements ObservableSorter {

    private final Set<SorterListener> sorterListeners = new HashSet<SorterListener>();


    public <T> boolean smaller(@NotNull Comparator<T> comparator, List<T> list, int e1, int e2){
        sorterListeners.forEach(sorterListener -> sorterListener.greater(e1, e2));
        return comparator.compare(list.get(e1),list.get(e2)) < 0;
    }

    public <T> void swap(@NotNull List<T> list, int e1, int e2){
        sorterListeners.forEach(sorterListener -> sorterListener.swap(e1, e2));
        list.set(e1, list.set(e2, list.get(e1)));
    }


    public void addSorterListener(@NotNull final SorterListener listener){
        for (SorterListener sorterListener : sorterListeners) {
            if (sorterListener.equals(listener)) {
                break;
            }
        }
        sorterListeners.add(listener);

    }

    public void removeSorterListener(@NotNull final SorterListener listener) {
        sorterListeners.removeIf(sorterListener -> sorterListener.equals(listener));

    }


}
