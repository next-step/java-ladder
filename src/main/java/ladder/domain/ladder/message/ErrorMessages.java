package ladder.domain.ladder.message;

public enum ErrorMessages {
    OVER_RANGE("1 ~ 10 까지만 입력이 가능합니다."),
    CANT_INPUT_LESS_THAN_ZERO("0을 입력할 수 없습니다.");
    
    private String message;
    
    ErrorMessages(String message) {
        this.message = message;
    }
    
    public String message() {
        return message;
    }
}
