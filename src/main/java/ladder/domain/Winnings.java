package ladder.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Winnings {
    private static final String WINNING_EMPTY_ERROR = "결과가 없습니다.";
    private static final String WINNING_COUNT_ERROR = "참가자 수와 동일한 결과를 입력해야합니다.";

    private final List<Winning> winnings;

    public Winnings(String inputWinning, int countOfPerson) {
        validEmpty(inputWinning);
        this.winnings = stringToList(inputWinning, countOfPerson);
    }

    private List<Winning> stringToList(String inputText, int countOfPerson) {
        String[] names = inputText.split(",");
        validResultSizeEqualToPersonCount(names.length, countOfPerson);
        return Arrays.stream(names)
                .map(Winning::new)
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

    public List<Winning> readOnlyWinning() {
        return Collections.unmodifiableList(winnings);
    }
}
