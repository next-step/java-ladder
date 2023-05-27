package ladder.domain.result;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LadderResult {

    private final List<String> results;

    public LadderResult(List<String> results) {
        this.results = results;
    }

    public static LadderResult of(List<String> results) {
        return new LadderResult(results);
    }

    public static LadderResult of(String results) {
        return new LadderResult(Arrays.stream(results.split(","))
            .map(String::trim)
            .collect(Collectors.toList()));
    }

    public List<String> results() {
        return List.copyOf(results);
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
        return Objects.equals(results, that.results);
    }

    @Override
    public int hashCode() {
        return Objects.hash(results);
    }

}
