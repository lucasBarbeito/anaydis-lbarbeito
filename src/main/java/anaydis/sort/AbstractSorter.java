package anaydis.sort;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.List;

/**
 * Abstract sorter: all sorter implementations should subclass this class.
 */
abstract class AbstractSorter implements Sorter {

    public <T> boolean smaller(@NotNull Comparator<T> comparator, List<T> list, int e1, int e2){
        return comparator.compare(list.get(e1),list.get(e2)) < 0;
    }
    public <T> void swap(@NotNull List<T> list, int e1, int e2){
        list.set(e1, list.set(e2, list.get(e1)));
    }






}
