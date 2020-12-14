package ladder.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LadderResult {

    private static final String SPLIT_LETTER = ",";
    protected static final String RESULT_CAN_NOT_BE_BLANK = "Result can not be blank.";

    private final List<String> results;

    public LadderResult(String gameResults) {
        this.results = split(gameResults);
    }

    private List<String> split(String gameResults) {
        String[] dividedName = gameResults.split(SPLIT_LETTER);
        return Arrays.stream(dividedName)
                .distinct()
                .map(this::valid)
                .collect(Collectors.toList());
    }

    private String valid(String name) {
        if (name.isEmpty() | name.trim().isEmpty()) {
            throw new IllegalArgumentException(RESULT_CAN_NOT_BE_BLANK);
        }
        return name;
    }

    boolean containsAll(List<String> results) {
        return this.results.containsAll(results);
    }
}
