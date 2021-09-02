package step2.model;

import java.util.Objects;

import static step2.model.LadderValidator.isBlank;

public class Result {
    private final String result;

    public Result(String result) {
        isBlank(result);
        this.result = result.trim();
    }

    public String getResult() {
        return result;
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
