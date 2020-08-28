package ladder.domain;

import ladder.exception.LadderExceptionMessage;
import ladder.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LadderResult {
    private static final String DELIMITER = ",";
    private List<String> results;

    private LadderResult(List<String> results) {
        this.results = results;
    }

    public LadderResult(String... inputs) {
        this.results = new ArrayList<>(Arrays.asList(inputs));
    }

    public static LadderResult of(Participants participants, String resultInput) {
        List<String> results = splitBy(resultInput, DELIMITER);

        if (StringUtils.isEmpty(resultInput) || participants.getNumber() != results.size()) {
            throw new IllegalArgumentException(LadderExceptionMessage.INVALID_LADDER_RESULT_COUNT);
        }

        return new LadderResult(results);
    }

    private static List<String> splitBy(String input, String delimiter) {
        return Arrays.stream(StringUtils.split(input, delimiter))
                .collect(Collectors.toList());
    }

    public String getResultBy(int index) {
        return "";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderResult that = (LadderResult) o;
        return results.equals(that.results);
    }

    @Override
    public int hashCode() {
        return Objects.hash(results);
    }
}
