package ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LadderResults {
    private final List<LadderResult> results;

    public LadderResults(String inputValue) {
        this.results = convertToResult(inputValue);
    }

    private List<LadderResult> convertToResult(String inputValue) {
        return Arrays.stream(inputValue.split(","))
                .map(LadderResult::new)
                .collect(Collectors.toList());
    }
}
