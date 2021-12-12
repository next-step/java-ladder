package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LadderResults {

    private static final String INPUT_STRING_REGEX = ",";

    private final List<String> results;

    private LadderResults(List<String> result) {
        this.results = result;
    }

    public static LadderResults create(String input) {
        return new LadderResults(
            Arrays.stream(input.split(INPUT_STRING_REGEX))
                .collect(Collectors.toList()));
    }

    public String get(Participant participant) {
        return results.get(participant.getPosition());
    }

    public List<String> getResults() {
        return Collections.unmodifiableList(results);
    }

}
