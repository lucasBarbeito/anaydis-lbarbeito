package anaydis.sort;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.List;

public class ShellSorter extends HSorter{

    @Override
    public @NotNull SorterType getType(){
        return SorterType.SHELL;
    }
    @Override
    public <T> void sort(@NotNull Comparator<T> comparator, @NotNull List<T> list) {
        int h;
        for (h = 1; h <= list.size()/9; h = (3 * h) + 1);
        for (;h > 0; h /= 3){
            sort(comparator, list, h);
        }
    }

    public <T> void sort(@NotNull Comparator<T> comparator, @NotNull List<T> list, int[] ns){
        for (int n : ns) {
            if (n <= list.size()){
                super.sort(comparator, list, n);
            }
        }
    }
}
