package ladder.domain.ladderresult;

import java.util.Objects;

public class LadderResult {
    private final String ladderResult;

    public LadderResult(String ladderResult) {
        this.ladderResult = ladderResult;
    }

    public String ladderResult() {
        return ladderResult;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LadderResult)) return false;

        LadderResult that = (LadderResult) o;

        return Objects.equals(ladderResult, that.ladderResult);
    }

    @Override
    public int hashCode() {
        return ladderResult != null ? ladderResult.hashCode() : 0;
    }
}
