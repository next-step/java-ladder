package nextstep.ladder.exception;

public enum ExceptionMessage {

    OUT_OF_RANGE("이름은 최대 5글자 까지 입니다."),
    CAN_NOT_NONE("이름은 비어 있을 수 없습니다."),
    CAN_NOT_TRUE_STRAIGHT("사다리의 다리는 연속으로 존재할 수 없습니다."),
    OUT_OF_INDEX("매개변수의 값이 인덱스 범위를 벗어났습니다."),
    CAN_NOT_EQUAL_NAME("플레이어의 이름은 같을 수 없습니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String message() {
        return this.message;
    }
}
