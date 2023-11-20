package ladder.domain;

import ladder.exception.ResultBlankException;

public class Result {

    private final String result;

    public Result(String result) {
        validate(result);
        this.result = result;
    }

    private void validate(String result) {
        if (result == null || result.isBlank()) {
            throw new ResultBlankException();
        }
    }

    public String result() {
        return this.result;
    }

}
