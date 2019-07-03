package ladder.domain.gamer.message;

public enum ErrorMessages {
    EMPTY_INPUT("빈 문자열이나 null 을 입력할 수 없습니다."),
    REQUIRE_NOT_KOREAN("알파벳이나 숫자만 입력이 가능합니다."), 
    NOT_MATCH_LADDER("사다리가 제대로 생성되지 않았습니다."),
    NOT_MATCH_REWARD("보상정보가 제대로 생성되지 않았습니다.");
    
    private String message;
    
    ErrorMessages(String message) {
        this.message = message;
    }
    
    public String message() {
        return message;
    }
}
