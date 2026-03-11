import java.util.*;

class AutocompleteSystem {

    HashMap<String, Integer> queries = new HashMap<>();

    void addQuery(String q) {

        queries.put(q, queries.getOrDefault(q, 0) + 1);
    }

    List<String> search(String prefix) {

        List<String> results = new ArrayList<>();

        for (String q : queries.keySet()) {

            if (q.startsWith(prefix))
                results.add(q);
        }

        return results;
    }

    public static void main(String[] args) {

        AutocompleteSystem a = new AutocompleteSystem();

        a.addQuery("java tutorial");
        a.addQuery("javascript guide");

        System.out.println(a.search("jav"));
    }
}
