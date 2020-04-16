package ladder.domain.result;

import java.util.Objects;

public class LadderResult {

    private final String ladderResult;

    public LadderResult(String result) {
        this.ladderResult = result;
    }

    public String showResult(){
        return ladderResult;
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
