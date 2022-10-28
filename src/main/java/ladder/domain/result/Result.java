package ladder.domain.result;

import ladder.exception.InputLengthException;

import java.util.Objects;

import static ladder.util.LadderConst.*;

public class Result {

    private final String result;

    public Result(String result) {
        if (result.length() > INPUT_LENGTH_MAX) {
            throw new InputLengthException(INPUT_LENGTH_MAX);
        }
        this.result = result;
    }

    public String result(){
        return this.result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result result1 = (Result) o;
        return Objects.equals(result, result1.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(result);
    }
}
