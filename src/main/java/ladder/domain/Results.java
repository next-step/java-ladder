package ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Results {
    private final List<String> initResults;

    private Results(List<String> results) {
        this.initResults = results;
    }

    public static Results of(List<String> results) {
        return new Results(results);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Results results1 = (Results) o;
        return Objects.equals(initResults, results1.initResults);
    }

    @Override
    public int hashCode() {
        return Objects.hash(initResults);
    }

    public List<String> getList() {
        return Collections.unmodifiableList(initResults);
    }

    public String getResultByPosition(int position) {
        return initResults.get(position);
    }

    public Results getFinalResults(Positions positions) {
        return new Results(makeFinalResultsByPositions(positions));
    }

    private List<String> makeFinalResultsByPositions(Positions positions) {
        return positions.makeFinalResults(initResults);
    }
}
