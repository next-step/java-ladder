package ladder.exception;

public class ErrorMessage {

    public static final String IS_NULL_OR_EMPTY = "입력 값이 null 이거나 빈 공백 문자입니다.";
    public static final String NULL_VALUE = "입력값이 null 입니다.";

    public static final String RANGE_OF_PLAYER_NAME = "참여자의 이름은 5글자를 넘길 수 없습니다.";
    public static final String REQUIRED_MIN_PILLAR_COUNT = "기둥의 개수는 최소 1 이상이여야 합니다.";
    public static final String REQUIRED_MIN_LADDER_HEIGHT = "사다리의 높이는 최소 1 이상이여야 합니다.";
    public static final String REQUIRED_MIN_STAIR_POSITION = "계단의 위치는 0 이상이어야 합니다.";

    private ErrorMessage() {
    }
}
