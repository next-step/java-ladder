package ladder.domain;

import ladder.exception.LadderExceptionMessage;
import ladder.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

public class LadderReward {
    private static final String DELIMITER = ",";
    private List<String> results;

    private LadderReward(List<String> results) {
        this.results = results;
    }

    public LadderReward(String... inputs) {
        this.results = new ArrayList<>(Arrays.asList(inputs));
    }

    public static LadderReward of(Participants participants, String resultInput) {
        List<String> results = splitBy(resultInput, DELIMITER);

        if (StringUtils.isEmpty(resultInput) || participants.getNumber() != results.size()) {
            throw new IllegalArgumentException(LadderExceptionMessage.INVALID_LADDER_RESULT_COUNT);
        }

        return new LadderReward(results);
    }

    private static List<String> splitBy(String input, String delimiter) {
        return Arrays.stream(StringUtils.split(input, delimiter))
                .collect(Collectors.toList());
    }

    public List<String> getResults() {
        return results;
    }

    public String getResultBy(int index) {
        return results.get(index);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderReward that = (LadderReward) o;
        return results.equals(that.results);
    }

    @Override
    public int hashCode() {
        return Objects.hash(results);
    }
}
