package nextstep.ladder.entity.ladder;

import nextstep.ladder.util.StringUtil;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LadderResults {
    private final List<LadderResult> ladderResults;

    public LadderResults(String resultsInput) {
        this.ladderResults = ladderResultsByString(resultsInput);
    }

    private List<LadderResult> ladderResultsByString(String resultsInput) {

        String[] results = StringUtil.splitCommaByString(resultsInput);

        return Arrays.stream(results)
                .map(LadderResult::new)
                .collect(Collectors.toList());
    }

    public String positionResult(int position) {
        return ladderResults.get(position).result();
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
