package nextstep.ladder.domain.result;

public class LadderResult {
    private static final int RESULT_UPPER_BOUND = 5;

    private final String ladderResult;

    public LadderResult(String ladderResult) {
        this.ladderResult = ladderResult;
    }

    public String getLadderResult() {
        return ladderResult;
    }

    public String toString() {
        return String.format("%" + RESULT_UPPER_BOUND + "s", ladderResult);
    }
}
