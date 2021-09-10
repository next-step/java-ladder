package nextstep.ladder2;

public enum ErrorMessage {

    NAME_LENGTH("이름은 5자 이하로만 가능합니다."),
    INVALID_INDEX("유효하지 않는 인덱스 입니다."),
    INVALID_NAME("all 을 이름으로 지정할 수 없습니다.");
    private String message;
    ErrorMessage(String message){
        this.message = message;
    }

    public String message() {
        return message;
    }
}
