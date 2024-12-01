public class TaxiRevenueResult {
    private double revenue;
    private long rideCount;

    public TaxiRevenueResult(double revenue, long rideCount) {
        this.revenue = revenue;
        this.rideCount = rideCount;
    }

    public double getRevenue() {
        return revenue;
    }

    public long getRideCount() {
        return rideCount;
    }

    @Override
    public String toString() {
        return "Bevétele: " + revenue + ", Fuvarok száma: " + rideCount;
    }
}
