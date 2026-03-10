import java.util.*;

class UsernameChecker {

    HashMap<String, Integer> users = new HashMap<>();
    HashMap<String, Integer> attempts = new HashMap<>();

    boolean checkAvailability(String username) {

        attempts.put(username, attempts.getOrDefault(username, 0) + 1);

        return !users.containsKey(username);
    }

    List<String> suggestAlternatives(String username) {

        List<String> suggestions = new ArrayList<>();

        for (int i = 1; i <= 3; i++) {
            String candidate = username + i;

            if (!users.containsKey(candidate))
                suggestions.add(candidate);
        }

        suggestions.add(username.replace("_", "."));

        return suggestions;
    }

    String getMostAttempted() {

        int max = 0;
        String result = "";

        for (String key : attempts.keySet()) {

            if (attempts.get(key) > max) {
                max = attempts.get(key);
                result = key;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        UsernameChecker system = new UsernameChecker();

        system.users.put("john_doe", 1);

        System.out.println(system.checkAvailability("john_doe"));
        System.out.println(system.checkAvailability("jane_smith"));

        System.out.println(system.suggestAlternatives("john_doe"));
    }
}