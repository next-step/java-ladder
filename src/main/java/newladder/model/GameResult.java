package newladder.model;

import java.util.HashMap;
import java.util.Map;

public class GameResult {

    private final Map<User, String> results = new HashMap<>();

    public void addResult(User user, String prizeName) {
        results.put(user, prizeName);
    }

    public Map<User, String> getResult() {
        return results;
    }

    public String getResult(User user) {
        if (results.containsKey(user)) {
            return results.get(user);
        }
        throw new IllegalArgumentException();
    }

}
