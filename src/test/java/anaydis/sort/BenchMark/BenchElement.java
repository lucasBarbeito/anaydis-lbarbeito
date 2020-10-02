package anaydis.sort.BenchMark;

import anaydis.sort.SorterType;

public class BenchElement {
    private SorterType sorterType;
    private int size;
    private BenchResult benchResult;
    private DataSetCase dataSetCase;

    public BenchElement(SorterType sorterType, int size, BenchResult benchResult, DataSetCase dataSetCase ){
        this.sorterType = sorterType;
        this.size = size;
        this.benchResult = benchResult;
        this.dataSetCase = dataSetCase;
    }

    public BenchResult getBenchResult() {
        return benchResult;
    }

    public DataSetCase getDataSetCase() {
        return dataSetCase;
    }

    public int getSize() {
        return size;
    }

    public SorterType getSorterType() {
        return sorterType;
    }

    @Override
    public String toString() {
        return "sorterType= " + sorterType +
                ", size= " + size +
                ", dataSetCase= " + dataSetCase +
                ", Order= " + benchResult.getTotalOrder() +
                ", Time= " + benchResult.getTotalTime();
    }
}
