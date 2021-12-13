package nextstep.ladder.model.value;

import java.util.Objects;

public class LadderResult {

    private final String ladderResult;

    public LadderResult(String ladderResult) {
        this.ladderResult = ladderResult;
    }

    public String getLadderResult() {
        return ladderResult;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LadderResult that = (LadderResult) o;
        return Objects.equals(ladderResult, that.ladderResult);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ladderResult);
    }
}
