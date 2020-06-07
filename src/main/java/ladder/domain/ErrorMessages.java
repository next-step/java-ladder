package ladder.domain;

public class ErrorMessages {

    public static final String INVALID_PLAYER_NAME = "게임 참가자의 이름은 빈 문자열이 아닌 1 ~ 5자리의 문자만 가능합니다.";
    public static final String INVALID_PLAYER_COUNTS = "게임 참가자는 1명 이상이어야 합니다.";
    public static final String INVALID_LADDER_HEIGHT = "사다리 높이는 1 이상이어야 합니다.";

    private ErrorMessages() {
    }
}
