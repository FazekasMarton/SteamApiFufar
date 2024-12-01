import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Tasks {
    List<Fuvar> rides = new ArrayList<Fuvar>();

    public void ReadFile(String fileName) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line = br.readLine();
            while ((line = br.readLine()) != null){
                String[] parts = line.split(";");
                this.rides.add(new Fuvar(Integer.parseInt(parts[0]), LocalDateTime.parse(parts[1], formatter), Integer.parseInt(parts[2]), Double.parseDouble(parts[3].replace(",", ".")), Double.parseDouble(parts[4].replace(",", ".")), Double.parseDouble(parts[5].replace(",", ".")), parts[6]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public long GetNumberOfRides() {
        return this.rides.stream().count();
    }

    public TaxiRevenueResult GetTaxiRevenue(int id) {
        return new TaxiRevenueResult(
                rides.stream().filter(f -> f.getId() == id).mapToDouble(f -> f.getFare() + f.getTip()).sum(),
                rides.stream().filter(f -> f.getId() == id).count()
        );
    }

    public double GetTotalDistance() {
        return this.rides.stream().mapToDouble(Fuvar::getDistance).sum();
    }

    public Fuvar GetLongestDistance() {
        return this.rides.stream().max(Comparator.comparingDouble(Fuvar::getDistance)).get();
    }

    public Fuvar GetMostTippedRide(){
        return this.rides.stream().min(Comparator.comparingDouble(f -> f.getFare() / f.getTip())).get();
    }

    public double GetTotalDistanceInKM(int id) {
        return this.rides.stream().filter(f -> f.getId() == id).mapToDouble(Fuvar::getDistance).sum() * 1.6;
    }

    public MisbehavingRidesResult GetMisbehavingRides() {
        return new MisbehavingRidesResult(
                rides.stream().filter(f -> f.getFare() > 0 && f.getDuration() > 0 && f.getDistance() == 0).count(),
                rides.stream().filter(f -> f.getFare() > 0 && f.getDuration() > 0 && f.getDistance() == 0).mapToInt(Fuvar::getDuration).sum(),
                rides.stream().filter(f -> f.getFare() > 0 && f.getDuration() > 0 && f.getDistance() == 0).mapToDouble(f -> f.getFare() + f.getTip()).sum()
        );
    }

    public boolean IsThereRideById(int id) {
        return this.rides.stream().anyMatch(f -> f.getId() == id);
    }

    public List<Fuvar> GetShortestDurations() {
        return this.rides.stream().filter(f -> f.getDuration() > 0).sorted(Comparator.comparing(Fuvar::getDuration)).limit(3).toList();
    }

    public long GetNumberOfRidesByDate(LocalDate date) {
        return this.rides.stream().filter(f -> f.getStartTime().getMonth().equals(date.getMonth()) && f.getStartTime().getDayOfMonth() == date.getDayOfMonth()).count();
    }

    public double GetRateOfTipByDate(LocalDate date) {
        OptionalDouble averageTipRate = this.rides.stream()
                .filter(f -> f.getStartTime().getMonth().equals(date.getMonth()) && f.getStartTime().getDayOfMonth() == date.getDayOfMonth())
                .filter(f -> f.getFare() > 0 && f.getTip() > 0)
                .mapToDouble(f -> f.getTip() / f.getFare())
                .average();

        return averageTipRate.isPresent() ? (float) Math.round(averageTipRate.getAsDouble() * 100.0) / 100.0 : 0.0f;
    }
}
