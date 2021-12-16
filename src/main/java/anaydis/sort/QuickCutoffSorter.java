package anaydis.sort;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.List;

public class QuickCutoffSorter extends AbstractQuickSorter{

    private final InsertionSorter insertionSorter;

    public QuickCutoffSorter(){
        super(SorterType.QUICK_CUT);
        insertionSorter = new InsertionSorter();
    }

    @Override
    public <T> void sort(@NotNull Comparator<T> comparator, @NotNull List<T> list) {
        sort(comparator, list, 0, list.size() - 1);
    }

    public <T> void sort(@NotNull Comparator<T> comparator, @NotNull List<T> list, int l, int r) {
        quickSort(comparator, list, l, r, 0);
        insertionSorter.sort(comparator, list);
    }

    public <T> void quickSort(@NotNull Comparator<T> comparator, @NotNull List<T> list, int lo, int hi, int M) {
        if (hi - lo <= M) return;
        int i = partition(comparator, list, lo, hi);
        quickSort(comparator, list, lo, i-1, M);
        quickSort(comparator, list, i+1, hi, M);
    }

    public <T> void sort(@NotNull Comparator<T> comparator, @NotNull List<T> list, int M) {
        quickSort(comparator, list, 0, list.size()-1, M);
        insertionSorter.sort(comparator, list);
    }
}
