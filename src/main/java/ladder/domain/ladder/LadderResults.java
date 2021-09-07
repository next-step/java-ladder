package ladder.domain.ladder;

import static ladder.util.StringUtil.splitByComma;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LadderResults {

    private static final String INVALID_RESULTS_COUNT_ERROR_MESSAGE = "사람 수와 동일한 수의 결과가 입력되어야 한다.";

    private final List<String> results;

    public LadderResults(List<String> results) {
        this.results = results;
    }

    public static LadderResults from(String input, int userCount) {
        checkResultsCount(input, userCount);

        return new LadderResults(Arrays.stream(splitByComma(input))
            .collect(Collectors.toList()));
    }

    private static void checkResultsCount(String input, int userCount) {
        if (splitByComma(input).length != userCount) {
            throw new IllegalArgumentException(INVALID_RESULTS_COUNT_ERROR_MESSAGE);
        }
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
