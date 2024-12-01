import java.time.LocalDate;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Tasks t = new Tasks();
        t.ReadFile("fuvar.csv");
        System.out.println("Fuvarok száma: " + t.GetNumberOfRides());
        System.out.println("6185-ös taxis: " + t.GetTaxiRevenue(6185));
        System.out.println("Összesen megtett táv:: " + t.GetTotalDistance());
        System.out.println("Leghosszabb fuvar: " + t.GetLongestDistance());
        System.out.println("Legbőkezöbb borravalójú fuvar: " + t.GetMostTippedRide());
        System.out.println("4261-es taxis összesen megtett távja kilóméterben mérve: " + t.GetTotalDistanceInKM(4261));
        System.out.println("Hibás adatok: " + t.GetMisbehavingRides());
        System.out.println("Van 1452-es taxis?: " + (t.IsThereRideById(1452) ? "Van" : "Nincs"));
        System.out.println("Legrövidebb utazások: " + t.GetShortestDurations());
        System.out.println("Fuvarok száma december 24.-én: " + t.GetNumberOfRidesByDate(LocalDate.of(2024, 12, 24)));
        System.out.println("Borravaló aránya december 31.-én: " + t.GetRateOfTipByDate(LocalDate.of(2024, 12, 31)));
    }
}