package nextstep.ladder.exception;

public enum ExceptionMessage {

    OUT_OF_RANGE("이름은 최대 5글자 까지 입니다."),
    NOT_NONE("이름은 비어 있을 수 없습니다."),
    NOT_TRUE_STRAIGHT("사다리의 다리는 연속으로 존재할 수 없습니다."),
    NOT_POSITIVE("높이, 너비 값은 양의 정수만 가능합니다."),
    COORDINATE_IS_INIT("좌표 값은 이미 초기화 되었습니다."),
    COORDINATE_IS_NOT_INIT("좌표 초기화가 아직 이뤄지지 않았습니다."),
    COORDINATE_OUR_OF_RANGE("x값 또는 y값이 좌표의 범위를 벗어납니다."),
    NOT_FINISH("사다리 타기를 완료하지 못했습니다."),
    NOT_EXIST_PLAYER("해당 좌표 값에 존재하는 Player가 없습니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String message() {
        return this.message;
    }
}
