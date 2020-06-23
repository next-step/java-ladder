package ladder.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LadderResult {
    private final String result;

    public LadderResult(String result) {
        this.result = result;
    }

    public static LadderResult of(String result) {
        return new LadderResult(result);
    }

    public static List<LadderResult> of(List<String> result) {
        return result.stream().map(LadderResult::new).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderResult that = (LadderResult) o;
        return Objects.equals(result, that.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(result);
    }
}
