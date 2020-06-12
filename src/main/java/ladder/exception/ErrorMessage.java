package ladder.exception;

public class ErrorMessage {

    public static final String IS_NULL_OR_EMPTY = "입력 값이 null 이거나 빈 공백 문자입니다.";
    public static final String NULL_VALUE = "입력값이 null 입니다.";
    public static final String NOT_FOUND_PLAYER_NAME = "참여자의 이름을 찾을 수 없습니다.";

    public static final String REQUIRED_MIN_POSITION = "위치는 0 이상이어야 합니다.";
    public static final String REQUIRED_MIN_PILLAR_COUNT = "기둥의 개수는 최소 1 이상이여야 합니다.";
    public static final String REQUIRED_MIN_LADDER_HEIGHT = "사다리의 높이는 최소 1 이상이여야 합니다.";
    public static final String NOT_SAME_MATCHED_VALUE = "입력한 참여자 수와 실행 결과의 개수가 일치하지 않습니다.";

    public static final String NOT_ALLOW_REDUCE_IN_PARALLEL_ENV = "사다리 구성 순서보장을 위해 병렬 처리를 할 수 없습니다.";

    private ErrorMessage() {
    }
}
