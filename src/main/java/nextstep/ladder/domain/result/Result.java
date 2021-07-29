package nextstep.ladder.domain.result;

import nextstep.ladder.exception.NullArgumentException;
import nextstep.ladder.exception.OutOfRangeArgumentException;
import nextstep.util.StringUtils;

public class Result {
    private static final int MAXIMUM_LENGTH_OF_RESULT = 5;

    private final String result;

    private Result(String result) {
        validate(result);

        this.result = result;
    }

    private void validate(String result) {
        if (StringUtils.isEmpty(result)) {
            throw new NullArgumentException("Result");
        }

        if (result.length() > MAXIMUM_LENGTH_OF_RESULT) {
            throw OutOfRangeArgumentException.lessThanOrEqualTo(MAXIMUM_LENGTH_OF_RESULT, result.length());
        }
    }

    public static Result from(String result) {
        return new Result(result);
    }

    public String getResult() {
        return result;
    }
}
