import java.util.*;

class TokenBucket {

    int tokens;
    int maxTokens;
    long lastRefill;

    TokenBucket(int max) {

        tokens = max;
        maxTokens = max;
        lastRefill = System.currentTimeMillis();
    }
}

class RateLimiter {

    HashMap<String, TokenBucket> clients = new HashMap<>();

    boolean checkRateLimit(String id) {

        clients.putIfAbsent(id, new TokenBucket(5));

        TokenBucket bucket = clients.get(id);

        if (bucket.tokens > 0) {

            bucket.tokens--;

            return true;
        }

        return false;
    }

    public static void main(String[] args) {

        RateLimiter r = new RateLimiter();

        for (int i = 0; i < 7; i++)
            System.out.println(r.checkRateLimit("client1"));
    }
}