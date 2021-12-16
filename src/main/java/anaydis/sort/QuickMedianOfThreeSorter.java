package anaydis.sort;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.List;

public class QuickMedianOfThreeSorter extends AbstractQuickSorter{

    protected QuickMedianOfThreeSorter() {
        super(SorterType.QUICK_MED_OF_THREE);
    }

    public <T> void quickSort(@NotNull Comparator<T> comparator, @NotNull List<T> list, int lo, int hi) {
        if (hi <= lo) return;
        swap(list, (lo+hi)/2, hi-1);
        compSwap(comparator, list, lo, hi-1);
        compSwap(comparator, list, lo, hi);
        compSwap(comparator, list, hi-1, hi);
        int i = partition(comparator, list, lo, hi);
        quickSort(comparator, list, lo, i-1);
        quickSort(comparator, list, i+1, hi);
    }

    public <T> void sort(@NotNull Comparator<T> comparator, @NotNull List<T> list, int lo, int hi, int M) {
        if (hi - 1 <= M) return;
        swap(list, (lo+hi)/2, hi-1);
        compSwap(comparator, list, lo, hi-1);
        compSwap(comparator, list, lo, hi);
        compSwap(comparator, list, hi-1, hi);
        int i = partition(comparator, list, lo, hi);
        quickSort(comparator, list, lo, i-1);
        quickSort(comparator, list, i+1, hi);
    }

    public <T> void sort(@NotNull Comparator<T> comparator, @NotNull List<T> list, int M) {
        sort(comparator, list, 0, list.size() - 1, M);
    }

    @Override
    public <T> void sort(@NotNull Comparator<T> comparator, @NotNull List<T> list) {
        quickSort(comparator, list, 0, list.size() - 1);
    }
}
