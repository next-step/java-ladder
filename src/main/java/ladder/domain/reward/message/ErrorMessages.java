package ladder.domain.reward.message;

public enum ErrorMessages {
    NOT_MATCH_COUNT("입력된 보상 갯수와 문자열이 일치하지 않습니다."),
    CANT_INPUT_EMPTY_STRING("공백문자열이나 null 을 입력할 수 없습니다.");
    
    private String message;
    
    ErrorMessages(String message) {
        this.message = message;
    }
    
    public String message() {
        return message;
    }
}
