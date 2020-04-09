package ladder.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LadderResult {
    private static final String INSTANTIATE_ERROR_FORMAT = "Create LadderResult fail. result must be at least %d words: name=%s";
    private static final int MINIMUM_SIZE = 2;
    private final List<String> results;

    private LadderResult(List<String> results) {
        this.results = Collections.unmodifiableList(results);
    }

    public static LadderResult of(List<String> results){
        if (results.size() < MINIMUM_SIZE) {
            throw new IllegalArgumentException(String.format(INSTANTIATE_ERROR_FORMAT, MINIMUM_SIZE, Arrays.toString(results.toArray())));
        }
        return new LadderResult(results);
    }

    public List<String> getResults() {
        return results;
    }
}
