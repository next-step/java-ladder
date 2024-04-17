package ladder.domain;

import java.util.Iterator;
import java.util.List;

public class Results implements Iterable<String> {
    private final List<String> results;

    public Results(List<String> results) {
        this.results = results;
    }

    public int getResultsCount() {
        return results.size();
    }

    public String getResult(int location) {
        return results.get(location);
    }

    @Override
    public Iterator<String> iterator() {
        return results.iterator();
    }

}
