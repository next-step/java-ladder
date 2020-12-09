package ladder.context;

public enum ErrorMessage {
    NAME_NULL("이름을 입력하셔야 합니다."),
    NAME_SIZE("이름은 최대 5글자까지 가능합니다"),
    NAME_DULICATION("중복된 이름이 있습니다."),
    DIRECTION_VALID("유효하지 않은 값 입니다."),
    PRODUCTS_NULL("상품을 입력해주세요"),
    PRODUCTS_COUNT("플레이어와 상품의 수가 일치해야 합니다.");



    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
