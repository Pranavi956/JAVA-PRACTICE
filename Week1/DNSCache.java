import java.util.*;

class DNSEntry {

    String ip;
    long expiry;

    DNSEntry(String ip, int ttl) {

        this.ip = ip;
        this.expiry = System.currentTimeMillis() + ttl * 1000;
    }
}

class DNSCache {

    HashMap<String, DNSEntry> cache = new HashMap<>();

    String resolve(String domain) {

        if (cache.containsKey(domain)) {

            DNSEntry entry = cache.get(domain);

            if (System.currentTimeMillis() < entry.expiry)
                return entry.ip;

            else
                cache.remove(domain);
        }

        String ip = "172.217.14.206";

        cache.put(domain, new DNSEntry(ip, 300));

        return ip;
    }

    public static void main(String[] args) {

        DNSCache dns = new DNSCache();

        System.out.println(dns.resolve("google.com"));
        System.out.println(dns.resolve("google.com"));
    }
}
