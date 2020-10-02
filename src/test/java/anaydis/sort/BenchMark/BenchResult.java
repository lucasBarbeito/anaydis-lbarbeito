package anaydis.sort.BenchMark;

public class BenchResult {

    private long totalTime;
    private long totalOrder;

    public BenchResult(long totalTime, long totalOrder) {
        this.totalTime = totalTime;
        this.totalOrder = totalOrder;
    }


    public long getTotalOrder() {
        return totalOrder;
    }

    public long getTotalTime() {
        return totalTime;
    }
}
