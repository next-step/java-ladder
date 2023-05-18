package refactoring;

import java.util.ArrayList;
import java.util.List;

public class Results {

    private final List<String> results;

    public Results(final String[] results) {
        this.results = new ArrayList<>(List.of(results));
    }

    public String get(final int target) {
        return results.get(target);
    }

    public int size() {
        return results.size();
    }
}
