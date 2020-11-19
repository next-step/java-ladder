package nextstep.ladder;

public class CountOfPerson {
    public static final String INPUT_VALUE_RANGE_ERR_MSG = "참여하는 사람은 2명 이상이어야 합니다.";
    public final int value;

    private CountOfPerson(int value) {
        if (value < 2) {
            throw new IllegalArgumentException(INPUT_VALUE_RANGE_ERR_MSG);
        }
        this.value = value;
    }

    public static CountOfPerson of(int value) {
        return new CountOfPerson(value);
    }
}
