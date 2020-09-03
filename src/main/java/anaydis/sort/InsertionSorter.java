package anaydis.sort;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.List;

public class InsertionSorter extends AbstractSorter {
    @Override
    public <T> void sort(@NotNull Comparator<T> comparator, @NotNull List<T> list) {

        for (int i = 0; i < list.size(); i++){
            for (int j = i; j > 0; j--){
                if (smaller(comparator,list,j,j-1)){
                    swap(list,j,j-1);
                }else{
                    break;
                }
            }
        }

    }

    @NotNull
    @Override
    public SorterType getType() {
        return SorterType.INSERTION;
    }
}
