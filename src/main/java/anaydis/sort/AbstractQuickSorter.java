package anaydis.sort;

import java.util.Comparator;
import java.util.List;

abstract class AbstractQuickSorter extends AbstractSorter{

     protected AbstractQuickSorter(SorterType type) {
         super(type);
     }

    <T> int partition(Comparator<T> comparator, List<T> list, int lo, int hi) {
        int i = lo - 1;
        int j = hi;
        while(true){
            while (greater(comparator, list, hi, ++i)){
                if (i == hi) break;
            }
            while (greater(comparator, list, --j, hi)){
                if (j == lo) break;
            }
            if (i >= j) break;
            swap(list, i, j);
        }
        swap(list, i, hi);
        return i;
    }
 }
