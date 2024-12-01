import java.time.LocalDateTime;
import java.util.Date;

public class Fuvar {
    private int id;
    private LocalDateTime startTime;
    private int duration;
    private double distance;
    private double fare;
    private double tip;
    private String paymentType;

    public Fuvar(int id, LocalDateTime startTime, int duration, double distance, double fare, double tip, String paymentType) {
        this.id = id;
        this.startTime = startTime;
        this.distance = distance;
        this.fare = fare;
        this.tip = tip;
        this.paymentType = paymentType;
        this.duration = duration;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getFare() {
        return fare;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }

    public double getTip() {
        return tip;
    }

    public void setTip(double tip) {
        this.tip = tip;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    @Override
    public String toString() {
        return "Fuvar{" +
                "id=" + id +
                ", startTime=" + startTime +
                ", duration=" + duration +
                ", distance=" + distance +
                ", fare=" + fare +
                ", tip=" + tip +
                ", paymentType='" + paymentType + '\'' +
                '}';
    }
}
