package ladder.step2.domain;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class LadderResults {
    private static final String LADDER_RESULTS_INPUT_FORM = "([a-zA-Z]|[가-힣]|[0-9])+(,\\s?([a-zA-Z]|[가-힣]|[0-9])+)*";
    private static final String INPUT_EXCEPTION_MESSAGE = "올바른 입력 형식이 아닙니다. 다시 입력해주세요.";
    private static final String SPACE = " ";
    private static final String EMPTY = "";
    private static final String DELIMITER = ",";
    
    private final List<LadderResult> ladderResults;
    
    public LadderResults(final String input) {
        this.ladderResults = parseLadderResults(input);
    }
    
    private List<LadderResult> parseLadderResults(final String input) {
        checkLadderResultsInputForm(input);
        return Arrays.stream(split(input))
                .map(LadderResult::new)
                .collect(Collectors.toList());
    }
    
    private void checkLadderResultsInputForm(final String input) {
        final Matcher matcher = Pattern.compile(LADDER_RESULTS_INPUT_FORM).matcher(input);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(INPUT_EXCEPTION_MESSAGE);
        }
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