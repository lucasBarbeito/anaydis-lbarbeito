package anaydis.sort;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.List;

public class QuickThreeWaySorter extends AbstractQuickSorter{

    protected QuickThreeWaySorter() {
        super(SorterType.QUICK_THREE_PARTITION);
    }

    public <T> void sortAux(@NotNull Comparator<T> comparator, @NotNull List<T> list, int lo, int hi) {
        if (hi <= lo) return;
        int i = lo-1;
        int j = hi;
        int x = lo-1;
        int y = hi;
        int k;
        while (true){
            while (greater(comparator, list, hi, ++i)){
                if (i == hi) break;
            }
            while (greater(comparator, list, --j, hi)){
                if (j == lo) break;
            }
            if (i >= j) break;
            swap(list, i, j);
            if (equals(comparator, list, i, hi)){
                swap(list, ++x, i);
                if (equals(comparator, list, hi, j)){
                    swap(list, --y, j);
                }
            }
        }
        swap(list, i, hi);
        j = i - 1;
        for (k = lo; k <= x; k++, j--) {
            swap(list, k, j);
        }
        i = i + 1;
        for (k = hi-1; k >= y; k--, i++) {
            swap(list, k, i);
        }
        sortAux(comparator, list, lo, j);
        sortAux(comparator, list, i, hi);
    }

    @Override
    public <T> void sort(@NotNull Comparator<T> comparator, @NotNull List<T> list) {
        sortAux(comparator, list, 0, list.size() - 1);
    }
}
