package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.util.Arrays.*;

public class LadderResults {

    private final List<String> ladderResults;

    public LadderResults(String[] ladderResults) {
        this.ladderResults = new ArrayList<>();
        this.ladderResults.addAll(asList(ladderResults));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderResults that = (LadderResults) o;
        return Objects.equals(ladderResults, that.ladderResults);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ladderResults);
    }
}
