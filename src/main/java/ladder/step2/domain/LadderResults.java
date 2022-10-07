package ladder.step2.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LadderResults {
    private static final String SPACE = " ";
    private static final String EMPTY = "";
    private static final String DELIMITER = ",";
    
    private final List<LadderResult> ladderResults;
    
    public LadderResults(final String input) {
        this.ladderResults = parseLadderResults(input);
    }
    
    private List<LadderResult> parseLadderResults(final String input) {
        return Arrays.stream(split(input))
                .map(LadderResult::new)
                .collect(Collectors.toList());
    }
    
    private String[] split(final String input) {
        return removeSpace(input).split(DELIMITER);
    }
    
    private String removeSpace(final String input) {
        return input.replace(SPACE, EMPTY);
    }
    
    public List<LadderResult> getLadderResults() {
        return ladderResults;
    }
}
