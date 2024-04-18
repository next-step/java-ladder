package ladder.domain;

import java.util.Iterator;
import java.util.List;

public class Results implements Iterable<Result> {
    private final List<Result> results;

    public Results(List<Result> results) {
        this.results = results;
    }

    public int getResultsCount() {
        return results.size();
    }

    public String getResult(int location) {
        return results.get(location).getName();
    }

    @Override
    public Iterator<Result> iterator() {
        return results.iterator();
    }

}
