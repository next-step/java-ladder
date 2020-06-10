package ladder.exception;

public class NameLengthOutOfRangeException extends IllegalArgumentException {

    private static final String RANGE_OF_PLAYER_NAME = "참여자의 이름은 5글자를 넘길 수 없습니다. name: %s";

    public NameLengthOutOfRangeException(final String value) {
        super(String.format(RANGE_OF_PLAYER_NAME, value));
    }
}
