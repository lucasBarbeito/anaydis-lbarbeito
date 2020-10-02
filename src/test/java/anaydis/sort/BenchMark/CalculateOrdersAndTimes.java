package anaydis.sort.BenchMark;

import anaydis.sort.Sorter;
import anaydis.sort.SorterProviderImpl;
import anaydis.sort.gui.ObservableSorter;

public class CalculateOrdersAndTimes {

    static SorterProviderImpl sorterProvider = new SorterProviderImpl();
    static Benchmark benchmark = new Benchmark();
    static int[] elements = {10,50,500,1000,5000};
    static DataSetCase[] dataSetCases = {DataSetCase.ASCENDING,DataSetCase.RANDOM,DataSetCase.DESCENDING};


    public static void main(String[] args) {
        for (Sorter sorter : sorterProvider.getAllSorters()) {
            System.out.println(sorter.getType().toString());
            for (DataSetCase dataSetCase :dataSetCases){
                for (int size : elements) {
                    System.out.println(benchmark.calculate(size, dataSetCase, (ObservableSorter) sorter, 20)
                            .toString());
                }
            }


        }

    }


}
