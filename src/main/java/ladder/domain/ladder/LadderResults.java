package ladder.domain.ladder;

import static ladder.util.StringUtil.splitByComma;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LadderResults {

    private final List<String> results;

    public LadderResults(List<String> results) {
        this.results = results;
    }

    public static LadderResults of(String input) {
        return new LadderResults(Arrays.stream(splitByComma(input))
            .collect(Collectors.toList()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LadderResults that = (LadderResults) o;
        return Objects.equals(results, that.results);
    }

    @Override
    public int hashCode() {
        return Objects.hash(results);
    }
}
