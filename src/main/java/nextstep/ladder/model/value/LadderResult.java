package nextstep.ladder.model.value;

import java.util.Objects;

public class LadderResult {

    private static final int NAME_MAX_SIZE = 5;
    private static final String SIZE_ERROR_MSG = "사다리 결과 값은 5자리를 넘어 갈수 없습니다!!!";

    private final String ladderResult;

    public LadderResult(String ladderResult) {

        if(ladderResult.length() > NAME_MAX_SIZE) {
            throw new IllegalArgumentException(SIZE_ERROR_MSG);
        }

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
