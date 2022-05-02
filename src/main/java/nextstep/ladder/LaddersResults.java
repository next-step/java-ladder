package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.util.Arrays.*;
import static java.util.Collections.*;

public class LaddersResults {

    private final List<String> ladderResults;

    private LaddersResults(String[] ladderResults) {
        this.ladderResults = new ArrayList<>();
        this.ladderResults.addAll(asList(ladderResults));
    }

    public static LaddersResults makeLaddersResultsByUserInput(String[] laddersResults) {
        return new LaddersResults(laddersResults);
    }

    public String findLadderResultByEndPosition(int endPosition) {
        return ladderResults.get(endPosition);
    }

    public List<String> getLadderResults() {
        return unmodifiableList(ladderResults);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LaddersResults that = (LaddersResults) o;
        return Objects.equals(ladderResults, that.ladderResults);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ladderResults);
    }
}
