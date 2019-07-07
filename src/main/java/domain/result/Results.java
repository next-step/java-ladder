package domain.result;

import java.util.HashMap;
import java.util.Map;

public class Results {
    private Map<String, String> results;

    public Results() {
        this.results = new HashMap<>();
    }

    public void add(String name, String goal) {
        results.put(name, goal);
    }

    public String findOne(String name) {
        return results.get(name);
    }
}
