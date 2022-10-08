package ladder.step2.domain;

import java.util.Arrays;
import java.util.Collections;
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
    
    public LadderResults(final String ladderResults, final int playersSize) {
        this.ladderResults = parseLadderResults(ladderResults, playersSize);
    }
    
    private List<LadderResult> parseLadderResults(final String ladderResults, final int playersSize) {
        checkLadderResultsInputForm(ladderResults);
        
        final String[] split = split(ladderResults);
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
    
    private void checkLadderResultsInputForm(final String ladderResults) {
        final Matcher matcher = Pattern.compile(LADDER_RESULTS_INPUT_FORM).matcher(ladderResults);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(INPUT_EXCEPTION_MESSAGE);
        }
    }
    
    private String[] split(final String ladderResults) {
        return removeSpace(ladderResults).split(DELIMITER);
    }
    
    private String removeSpace(final String ladderResults) {
        return ladderResults.replace(SPACE, EMPTY);
    }
    
    public LadderResult getMatchingLadderResult(final Player player) {
        Position position = player.getPosition();
        return ladderResults.get(position.getPosition());
    }
    
    public List<LadderResult> getLadderResults() {
        return Collections.unmodifiableList(ladderResults);
    }
}