package nextstep.ladder.exception;

public enum ExceptionMessage {

    OUT_OF_RANGE("이름은 최대 5글자 까지 입니다."),
    NOT_NONE("이름은 비어 있을 수 없습니다."),
    NOT_TRUE_STRAIGHT("사다리의 다리는 연속으로 존재할 수 없습니다."),
    NOT_POSITIVE("높이, 너비 값은 양의 정수만 가능합니다."),
    NOT_FINISH("사다리 타기를 완료하지 못했습니다."),
    NOT_ENOUGH_PLAYER("게임 플레이어는 2명 이상이어야 합니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String message() {
        return this.message;
    }
}
