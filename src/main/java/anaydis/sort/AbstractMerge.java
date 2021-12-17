package anaydis.sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

abstract class AbstractMerge extends AbstractSorter{

    AbstractMerge(SorterType type) {
        super(type);
    }

    <T> void merge(Comparator<T> comparator, List<T> list, int lo, int middle, int hi){
        List<T> aux = new ArrayList<>(list);
        for (int i = lo; i <= middle; i++) {
            copy(aux, i, list, i);
        }
        for (int j = middle + 1; j <= hi; j++) {
            copy(aux, hi + (middle + 1) - j, list, j);
        }
        for (int k = lo, i = lo, j = hi; k <= hi; k++) {
            if (greater(comparator, aux, i, j)){
                copy(list, k, aux, j--);
            }else{
                copy(list, k, aux, i++);
            }
        }
    }
}
