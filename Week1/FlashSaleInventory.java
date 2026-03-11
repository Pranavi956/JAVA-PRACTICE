import java.util.*;

class FlashSaleInventory {

    HashMap<String, Integer> stock = new HashMap<>();
    LinkedList<Integer> waitingList = new LinkedList<>();

    int checkStock(String productId) {

        return stock.getOrDefault(productId, 0);
    }

    synchronized String purchaseItem(String productId, int userId) {

        int count = stock.getOrDefault(productId, 0);

        if (count > 0) {

            stock.put(productId, count - 1);

            return "Success";
        }

        waitingList.add(userId);

        return "Added to waiting list";
    }

    public static void main(String[] args) {

        FlashSaleInventory inv = new FlashSaleInventory();

        inv.stock.put("IPHONE15", 2);

        System.out.println(inv.purchaseItem("IPHONE15", 101));
        System.out.println(inv.purchaseItem("IPHONE15", 102));
        System.out.println(inv.purchaseItem("IPHONE15", 103));
    }
}
