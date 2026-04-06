import java.util.*;

class Asset {
    String name;
    double returnRate;

    Asset(String n, double r) {
        name = n; returnRate = r;
    }

    public String toString() {
        return name + ":" + returnRate;
    }
}

public class Problem4PortfolioSorting {

    public static void main(String[] args) {
        List<Asset> list = new ArrayList<>();
        list.add(new Asset("AAPL", 12));
        list.add(new Asset("TSLA", 8));
        list.add(new Asset("GOOG", 15));

        list.sort(Comparator.comparingDouble(a -> a.returnRate));
        System.out.println(list);

        list.sort((a, b) -> Double.compare(b.returnRate, a.returnRate));
        System.out.println(list);
    }
}