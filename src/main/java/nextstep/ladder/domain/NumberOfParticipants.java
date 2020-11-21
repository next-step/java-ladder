package nextstep.ladder.domain;

public class NumberOfParticipants {
    public static final String INPUT_VALUE_RANGE_ERR_MSG = "참여하는 사람은 2명 이상이어야 합니다.";
    private static final int MIN_AVAILABLE_NUMBER = 2;
    private final int value;

    private NumberOfParticipants(int value) {
        if (value < MIN_AVAILABLE_NUMBER) {
            throw new IllegalArgumentException(INPUT_VALUE_RANGE_ERR_MSG);
        }
        this.value = value;
    }

    public static NumberOfParticipants valueOf(int value) {
        return new NumberOfParticipants(value);
    }

    public int getPointsSize() {
        return value - 1;
    }
}
