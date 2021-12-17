package anaydis.sort;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.List;

public class MergeBottomUpSorter extends AbstractMerge{

    MergeBottomUpSorter() {
        super(SorterType.MERGE_BOTTOM_UP);
    }

    @Override
    public <T> void sort(@NotNull Comparator<T> comparator, @NotNull List<T> list) {
        sortAux(comparator, list, 0, list.size()-1);
    }

    public <T> void sortAux(Comparator<T> comparator, List<T> list, int lo, int hi){
        if (hi <= lo) return;
        for(int middle = 1; middle <= hi - lo; middle *= 2){
            for (int i = lo; i <= hi - middle; i += middle * 2){
                final int min = Math.min(i - lo + middle * 2 - 1, hi);
                merge(comparator, list, i, i + middle - 1, min);
            }
        }
    }
}
