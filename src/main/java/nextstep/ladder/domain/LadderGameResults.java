package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class LadderGameResults implements Iterable<LadderGameResult> {
    private final List<LadderGameResult> results;

    public LadderGameResults(List<LadderGameResult> results) {
        this.results = new ArrayList<>(results);
    }

    @Override
    public Iterator<LadderGameResult> iterator() {
        return results.iterator();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderGameResults that = (LadderGameResults) o;
        return Objects.equals(results, that.results);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(results);
    }
}
