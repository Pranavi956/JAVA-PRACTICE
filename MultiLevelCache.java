import java.util.*;

class MultiLevelCache {

    LinkedHashMap<String, String> L1 = new LinkedHashMap<>(10, 0.75f, true);

    HashMap<String, String> L2 = new HashMap<>();

    String getVideo(String id) {

        if (L1.containsKey(id))
            return "L1 HIT";

        if (L2.containsKey(id)) {

            L1.put(id, L2.get(id));

            return "L2 HIT";
        }

        String data = "video_data";

        L2.put(id, data);

        return "Database HIT";
    }

    public static void main(String[] args) {

        MultiLevelCache c = new MultiLevelCache();

        System.out.println(c.getVideo("video1"));
        System.out.println(c.getVideo("video1"));
    }
}