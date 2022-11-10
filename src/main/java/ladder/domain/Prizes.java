package ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Prizes {

    private final static String ERROR_EMPTY_VALUE = "입력 값이 누락되었습니다.";
    private final static String ERROR_UNDER_ONE_VALUE = "두 항목 이상 필요합니다.";
    private final static String ERROR_NOT_EQUAL_PARTICIPANTS_NUMBER = "참여자 수와 동일한 수의 결과가 필요합니다.";
    private final static String SEPARATOR = ",";

    private final List<Prize> value;

    public Prizes(final String prizes, final int totalParticipantsNumber) {
        validate(prizes);
        this.value = splitPrizes(prizes, totalParticipantsNumber);
    }

    private void validate(final String value) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException(ERROR_EMPTY_VALUE);
        }
    }

    private List<Prize> splitPrizes(final String value, final int totalParticipantsNumber) {
        String[] splited = value.split(SEPARATOR);
        if (splited.length <= 1) {
            throw new IllegalArgumentException(ERROR_UNDER_ONE_VALUE);
        }

        if (splited.length != totalParticipantsNumber) {
            throw new IllegalArgumentException(ERROR_NOT_EQUAL_PARTICIPANTS_NUMBER);
        }

        return IntStream.range(0, splited.length)
            .mapToObj(i -> new Prize(splited[i], i))
            .collect(Collectors.toList());
    }

    public List<Prize> getValue() {
        return Collections.unmodifiableList(value);
    }
}
