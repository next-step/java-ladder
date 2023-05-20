package nextstep.ladder.domain;

public class Result {

    private static final String RESULT_NOT_BLANK_MESSAGE = "결과는 공백일 수 없습니다.";

    private final String result;
    private final Position position;

    public Result(final String result, final Position position) {
        validate(result);
        this.result = result;
        this.position = position;
    }

    public void validate(final String result) {
        if (result.isBlank()) {
            throw new IllegalArgumentException(RESULT_NOT_BLANK_MESSAGE);
        }
    }

    public boolean isReach(final Position position) {
        return this.position.equals(position);
    }

    public String result() {
        return result;
    }

}
