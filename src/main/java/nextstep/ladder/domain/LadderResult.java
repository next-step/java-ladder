package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LadderResult {
    public static final String LADDER_RESULT_EMPTY_MSG = "사다리의 결과는 공백 일 수 없습니다.";
    public static final String RESULT_DELIMITER = ",";
    private String[] results;

    public LadderResult(final int countOfPerson, final String resultText) {
        emptyCheck(resultText);

        final String[] results = resultText.split(RESULT_DELIMITER);

        resultNumberCheck(countOfPerson, results);

        this.results = results;
    }

    private static void resultNumberCheck(final int countOfPerson, final String[] results) {
        if (results.length != countOfPerson) {
            throw new IllegalArgumentException("참가자의 수와 사다리 결과의 수는 다를 수 없습니다.");
        }
    }

    private void emptyCheck(final String resultText) {
        if (isNullOrEmpty(resultText)) {
            throw new IllegalArgumentException(LADDER_RESULT_EMPTY_MSG);
        }
    }

    private boolean isNullOrEmpty(final String resultText) {
        return resultText == null || resultText.isEmpty();
    }

    @Override
    public String toString() {
        final List<String> collect = Arrays.stream(this.results)
                .map(r -> String.format("%-6s", r))
                .collect(Collectors.toList());

        return String.join("", collect);
    }
}
