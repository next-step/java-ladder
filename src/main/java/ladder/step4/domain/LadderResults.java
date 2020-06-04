package ladder.step4.domain;

import ladder.step4.exception.LadderResultSizeException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class LadderResults {
    private final List<LadderResult> results;

    private LadderResults(List<LadderResult> results) {
        this.results = results;
    }

    public static LadderResults of(String results, Participants participants) {
        List<LadderResult> resultSet = Arrays.stream(results.split(","))
                                             .map(LadderResult::valueOf)
                                             .collect(toList());
        validate(resultSet, participants);
        return new LadderResults(resultSet);
    }

    private static void validate(List<LadderResult> results, Participants participants) {
        if (results.size() != participants.size()) {
            throw new LadderResultSizeException();
        }
    }

    public Stream<LadderResult> stream() {
        return results.stream();
    }

    public LadderResult get(int index) {
        return results.get(index);
    }
}
