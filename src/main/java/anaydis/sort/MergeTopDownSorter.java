package anaydis.sort;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.List;

public class MergeTopDownSorter extends AbstractMerge{

    MergeTopDownSorter() {
        super(SorterType.MERGE_TOP_DOWN);
    }

    @Override
    public <T> void sort(@NotNull Comparator<T> comparator, @NotNull List<T> list) {
        sortAux(comparator, list, 0, list.size()-1);
    }

    public <T> void sortAux(Comparator<T> comparator, List<T> list, int lo, int hi){
        if (lo < hi){
            int middle = (lo + hi) / 2;
            sortAux(comparator, list, lo, middle);
            sortAux(comparator, list, middle + 1, hi);
            merge(comparator, list, lo, middle, hi);
        }
    }
}
