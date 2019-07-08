package ladder.domain.ladder.message;

public enum ErrorMessages {
    CANT_INPUT_LESS_THAN_ZERO("0을 입력할 수 없습니다.");
    
    private String message;
    
    ErrorMessages(String message) {
        this.message = message;
    }
    
    public String message() {
        return message;
    }
}
