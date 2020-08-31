package ladder.exception;

public final class LadderExceptionMessage {
    public static final String PARTICIPANT_NAME_TOO_LONG = "참가자 이름은 5자 이하로 입력해주세요.";
    public static final String PARTICIPANT_NEED_MORE_THAN_ONE = "참가자는 적어도 1명 이상이어야 합니다.";
    public static final String PARTICIPANT_NAME_NEED_MORE_THAN_ONE = "참가자 이름은 적어도 1글자 이상이어야 합니다.";
    public static final String INVALID_LADDER_RESULT_COUNT = "실행 결과는 참가자의 수와 일치하게 입력해주세요.";
    public static final String INVALID_LINE_DIRECTION_INPUT = "옳지 못한 방향 정보입니다.";

    private LadderExceptionMessage() {
    }
}
