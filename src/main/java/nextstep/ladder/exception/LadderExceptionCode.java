package nextstep.ladder.exception;

public enum LadderExceptionCode {
    // player
    INVALID_NAME_FORMAT("이름은 null이거나 빈 값은 안됩니다."),
    INVAILD_NAME_LENGTH("이름은 0~5글자 사이어야 합니다."),
    NO_SUCH_PLAYER("해당 선수를 찾을 수 없습니다."),

    // ladder
    INVAILD_LADDER_HEIGHT("사다리 높이는 1이상 이어야 합니다."),
    FAIL_LADDER_INITIALIZATION("사다리는 라인이 1이상 이어야 합니다."),
    INVALID_HEIGHT("Height는 null이어선 안됩니다."),
    INVALID_LADDER_FORMAT("사다리 모양이 정상적이지 않습니다."),
    INVALID_GAME_EXIT("사다리 게임이 비정상적으로 끝났습니다."),

    // coordinate
    INVALID_COORDINATE_FORMAT("좌표의 x, y값은 0이상 이어야 합니다.");

    private final String message;

    LadderExceptionCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
