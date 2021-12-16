package anaydis.sort;

import org.jetbrains.annotations.NotNull;

import java.util.EnumMap;

public class SorterProviderImpl implements SorterProvider {

    private final EnumMap<SorterType,Sorter> sorters = new EnumMap<>(SorterType.class);

    public SorterProviderImpl(){
        sorters.put(SorterType.BUBBLE, new BubbleSorter());
        sorters.put(SorterType.INSERTION, new InsertionSorter());
        sorters.put(SorterType.SELECTION,new SelectionSorter());
        sorters.put(SorterType.QUICK, new QuickSorter());
        sorters.put(SorterType.QUICK_CUT, new QuickCutoffSorter());
        sorters.put(SorterType.QUICK_NON_RECURSIVE, new QuickNonRecursiveSorter());
        sorters.put(SorterType.QUICK_MED_OF_THREE, new QuickMedianOfThreeSorter());
        sorters.put(SorterType.QUICK_THREE_PARTITION, new QuickThreeWaySorter());

    }



    @NotNull
    @Override
    public Iterable<Sorter> getAllSorters() {
        return sorters.values();
    }


    @NotNull
    @Override
    public Sorter getSorterForType(@NotNull SorterType type) {
        return sorters.get(type);
    }
}
