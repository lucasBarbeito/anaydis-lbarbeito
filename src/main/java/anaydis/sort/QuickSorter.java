package anaydis.sort;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.List;

public class QuickSorter extends AbstractQuickSorter{

    public QuickSorter() {
        super(SorterType.QUICK);
    }

    public <T> void sortAux(@NotNull Comparator<T> comparator, @NotNull List<T> list, int lo, int hi) {
        if (hi <= lo) return;
        int i = partition(comparator, list, lo, hi);
        sortAux(comparator, list, lo, i-1);
        sortAux(comparator, list, i+1, hi);
    }

    @Override
    public <T> void sort(@NotNull Comparator<T> comparator, @NotNull List<T> list) {
        sortAux(comparator, list, 0, list.size()-1);
    }


}
