package nextstep.step4.domain;

import java.util.List;
import java.util.Objects;

public class LadderResult {

    private final List<String> ladderResult;

    private LadderResult(List<String> ladderResult) {
        this.ladderResult = ladderResult;
    }

    public static LadderResult from(List<String> ladderResult) {
        return new LadderResult(ladderResult);
    }

    public String findLadderResultByEndColumn(int endColumn) {
        return ladderResult.get(endColumn);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderResult that = (LadderResult) o;
        return Objects.equals(ladderResult, that.ladderResult);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ladderResult);
    }
}
