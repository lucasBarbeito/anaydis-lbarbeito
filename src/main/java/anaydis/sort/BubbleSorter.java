package anaydis.sort;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.List;

public class BubbleSorter extends AbstractSorter {
    @Override
    public <T> void sort(@NotNull Comparator<T> comparator, @NotNull List<T> list) {
        for (int i = list.size() - 1; i > 0; i--){
            for (int j = 0; j < i ; j++){
                if (!smaller(comparator,list,j,j + 1)){
                    swap(list,j,j +1);
                }
            }
        }

    }

    @NotNull
    @Override
    public SorterType getType() {
        return SorterType.BUBBLE;
    }
}
