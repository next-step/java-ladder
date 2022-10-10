package ladder.domain;

import java.util.Objects;

public class LadderResult {
    private final String ladderResult;
    private final int position;

    public LadderResult(String ladderResult, int position) {
        this.ladderResult = ladderResult;
        this.position = position;
    }

    public String ladderResult() {
        return ladderResult;
    }

    public int position() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LadderResult)) return false;

        LadderResult that = (LadderResult) o;

        if (position != that.position) return false;
        return Objects.equals(ladderResult, that.ladderResult);
    }

    @Override
    public int hashCode() {
        int result = ladderResult != null ? ladderResult.hashCode() : 0;
        result = 31 * result + position;
        return result;
    }
}
