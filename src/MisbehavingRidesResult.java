public class MisbehavingRidesResult {
    private long count;
    private int totalDuration;
    private double totalRevenue;

    public MisbehavingRidesResult(long count, int totalDuration, double totalRevenue) {
        this.count = count;
        this.totalDuration = totalDuration;
        this.totalRevenue = totalRevenue;
    }

    public long getCount() {
        return count;
    }

    public int getTotalDuration() {
        return totalDuration;
    }

    public double getTotalRevenue() {
        return totalRevenue;
    }

    @Override
    public String toString() {
        return "MisbehavingRidesResult{" +
                "count=" + count +
                ", totalDuration=" + totalDuration +
                ", totalRevenue=" + totalRevenue +
                '}';
    }
}
