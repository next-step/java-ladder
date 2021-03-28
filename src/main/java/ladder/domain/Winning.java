package ladder.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Winning {
    private static final String WINNING_EMPTY_ERROR = "결과가 없습니다.";
    private static final String WINNING_COUNT_ERROR = "참가자 수와 동일한 결과를 입력해야합니다.";
    private static final String RESULT_MAX_LENGTH_ERROR = "결과는 최대 5글자 입니다.";
    private static final int RESULT_MAX_LENGTH = 5;

    private final List<String> results;

    public Winning(String inputWinning, int countOfPerson) {
        validEmpty(inputWinning);
        this.results = stringToList(inputWinning, countOfPerson);
    }

    private List<String> stringToList(String inputText, int countOfPerson) {
        String[] names = inputText.split(",");
        validResultSizeEqualToPersonCount(names.length, countOfPerson);
        return Arrays.stream(names)
                .map(this::validResultLengthFiveOver)
                .collect(Collectors.toList());
    }

    private void validResultSizeEqualToPersonCount(int countOfWinning, int countOfPerson) {
        if (countOfWinning != countOfPerson) {
            throw new IllegalArgumentException(WINNING_COUNT_ERROR);
        }
    }

    private void validEmpty(String inputText) {
        if (inputText == null
                || inputText.trim().isEmpty()) {
            throw new IllegalArgumentException(WINNING_EMPTY_ERROR);
        }
    }

    private String validResultLengthFiveOver(String result) {
        if (result.isEmpty()
                || result.length() > RESULT_MAX_LENGTH) {
            throw new IllegalArgumentException(RESULT_MAX_LENGTH_ERROR);
        }
        return result;
    }

    public List<String> readOnlyWinning() {
        return Collections.unmodifiableList(results);
    }
}
