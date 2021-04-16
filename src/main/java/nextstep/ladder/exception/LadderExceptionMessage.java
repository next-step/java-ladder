package nextstep.ladder.exception;

public enum LadderExceptionMessage {
    CHECK_PRIZES_LENGTH("결과 목록의 길이는 플레이어 목록의 길이와 같아야합니다."),
    CHECK_LADDER_HEIGHT("사다리 높이가 1미만인지 확인해주세요."),
    CHECK_CONTIONUOUS_POINT("가로 라인이 겹치는 지 확인해주세요."),
    CHECK_NAME_DUPLICATION("중복되는 이름의 플레이어가 존재하는 지 확인해주세요."),
    CHECK_NAME_LENGTH("이름이 5자를 초과하는지 확인해주세요."),
    CHECK_TARGET_PLAYER_NAME("입력하신 플레이어가 존재하지 않습니다.");

    private final String message;

    LadderExceptionMessage(String message) {
        this.message = message;
    }

    public String errorMessage() {
        return message;
    }
}
