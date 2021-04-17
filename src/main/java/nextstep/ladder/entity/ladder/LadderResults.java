package nextstep.ladder.entity.ladder;

import nextstep.ladder.common.Constants;
import nextstep.ladder.util.StringUtil;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LadderResults {

    private final List<LadderResult> ladderResults;

    public LadderResults(String resultsInput, int userCount) {
        this.ladderResults = ladderResultsByString(resultsInput, userCount);
    }

    private List<LadderResult> ladderResultsByString(String resultsInput, int userCount) {

        String[] results = StringUtil.splitCommaByString(resultsInput);

        if (userCount != results.length) {
            throw new IllegalArgumentException(Constants.LADDER_RESULT_INPUT_ERROR_MESSAGE);
        }

        return Arrays.stream(results)
                .map(LadderResult::new)
                .collect(Collectors.toList());
    }

    public String positionResult(int position) {
        return ladderResults.get(position).result();
    }

    public String positionResult(String name, int position) {
        return name + Constants.USER_AND_POSITION_APPEND_STRING + ladderResults.get(position).result();
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
