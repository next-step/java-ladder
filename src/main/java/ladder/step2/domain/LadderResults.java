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
    private static final String NOT_EQUALS_LENGTH_EXCEPTION_MESSAGE = "플레이어 수 만큼만 입력할 수 있습니다. 다시 입력해주세요.";
    
    private final List<LadderResult> ladderResults;
    
    public LadderResults(final String input, final int playersSize) {
        this.ladderResults = parseLadderResults(input, playersSize);
    }
    
    private List<LadderResult> parseLadderResults(final String input, final int playersSize) {
        checkLadderResultsInputForm(input);
        final String[] split = split(input);
        checkCountOfLadderResults(split, playersSize);
        return Arrays.stream(split)
                .map(LadderResult::new)
                .collect(Collectors.toList());
    }
    
    private void checkCountOfLadderResults(final String[] split, final int playersSize) {
        if (split.length != playersSize) {
            throw new IllegalArgumentException(NOT_EQUALS_LENGTH_EXCEPTION_MESSAGE);
        }
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