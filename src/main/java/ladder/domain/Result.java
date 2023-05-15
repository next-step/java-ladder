package ladder.domain;

import java.util.List;
import java.util.Objects;

import static ladder.utils.StringSplitter.splitStrings;

public class Result {
    private final List<String> result;

    public Result(List<String> result) {
        this.result = result;
    }

    public Result(String strings) {
        this.result = splitStrings(strings);
    }

    public int size() {
        return result.size();
    }

    public String getResultByPosition(int position) {
        return result.get(position);
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
