import java.util.*;

class ParkingLot {

    String[] lot = new String[10];

    int hash(String plate) {

        return Math.abs(plate.hashCode()) % lot.length;
    }

    int park(String plate) {

        int index = hash(plate);

        while (lot[index] != null)
            index = (index + 1) % lot.length;

        lot[index] = plate;

        return index;
    }

    public static void main(String[] args) {

        ParkingLot p = new ParkingLot();

        System.out.println(p.park("ABC123"));
        System.out.println(p.park("XYZ999"));
    }
}
