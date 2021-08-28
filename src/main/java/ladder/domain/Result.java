package ladder.domain;

import java.util.Objects;

import ladder.exception.NullValueException;
import ladder.exception.ResultLengthException;

public class Result {
    private static final String RESULT_IS_NULL_EXCEPTION_COMMENT = "결과값이 널입니다.";
    private static final String RESULT_LENGTH_EXCEPTION_COMMENT = "결과값의 길이가 0이하 입니다.";

    private final String result;

    private Result(String result) {
        validate(result);
        this.result = result;
    }

    public static Result from(String result) {
        return new Result(result);
    }

    private void validate(String result) {
        if (Objects.isNull(result)) {
            throw new NullValueException(RESULT_IS_NULL_EXCEPTION_COMMENT);
        }

        if (result.length() <= 0) {
            throw new ResultLengthException(RESULT_LENGTH_EXCEPTION_COMMENT);
        }
    }

    public String result() {
        return result;
    }
}
