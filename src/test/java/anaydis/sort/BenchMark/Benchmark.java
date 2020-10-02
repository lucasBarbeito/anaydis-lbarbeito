package anaydis.sort.BenchMark;

import anaydis.sort.*;
import anaydis.sort.gui.ObservableSorter;
import anaydis.sort.gui.SorterListener;
import anaydis.sort.listener.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Benchmark {


    IntegerDataSetGenerator integerDataSetGenerator = new IntegerDataSetGenerator();
    Comparator<Integer> comparator = integerDataSetGenerator.getComparator();

    public BenchElement calculate(int size, DataSetCase dataSetCase, ObservableSorter sorter, int iterations){
        long totalTime = 0;
        long totalOrder = 0;
        OrderSorterListener orderSorterListener = new OrderSorterListener();
        sorter.addSorterListener(orderSorterListener);

        for (int i = 0 ; i < iterations; i++){
            List<Integer> dataSet = creatDataSet(dataSetCase,size);
            orderSorterListener.begin();
            sorter.sort(comparator,dataSet);
            totalTime  += orderSorterListener.stop().getTotalTime();
            totalOrder += orderSorterListener.stop().getTotalOrder();
        }

        return new BenchElement(sorter.getType(),size,
                new BenchResult(totalTime/iterations,totalOrder/iterations),dataSetCase);

    }

    private List<Integer> creatDataSet(DataSetCase dataSetCase , int size){
        List<Integer> dataset = new ArrayList<>();
        switch (dataSetCase){
            case ASCENDING:
                 dataset = integerDataSetGenerator.createAscending(size);
                 break;
            case RANDOM:
                 dataset = integerDataSetGenerator.createRandom(size);
                 break;
            case DESCENDING:
                dataset = integerDataSetGenerator.createDescending(size);
                break;
        }
        return dataset;
    }
}
