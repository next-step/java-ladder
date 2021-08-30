package ladder.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LadderResults {

    private static final String SEPARATOR = ",";

    private final List<LadderResult> ladderResults;

    private LadderResults(List<LadderResult> ladderResults) {
        this.ladderResults = ladderResults;
    }

    public static LadderResults create(String results) {
        return Arrays.stream(results.split(SEPARATOR))
                .map(LadderResult::create)
                .collect(Collectors.collectingAndThen(Collectors.toList(), LadderResults::new));
    }

    public List<String> allNames() {
        return Collections.unmodifiableList(ladderResults)
                .stream()
                .map(LadderResult::getResult)
                .collect(Collectors.toList());
    }

    public LadderResult get(int idx) {
        return ladderResults.get(idx);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderResults ladderResults1 = (LadderResults) o;
        return Objects.equals(ladderResults, ladderResults1.ladderResults);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ladderResults);
    }
}
