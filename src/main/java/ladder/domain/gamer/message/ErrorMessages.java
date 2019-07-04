package ladder.domain.gamer.message;

public enum ErrorMessages {
    EMPTY_INPUT("빈 문자열이나 null 을 입력할 수 없습니다."),
    REQUIRE_NOT_KOREAN("알파벳이나 숫자만 입력이 가능합니다."), 
    OVER_INPUT_LADDER_SIZE("사다리 갯수보다 큰 수가 입력되었습니다."), 
    NOT_FIND_GAMER("고객 이름을 찾을 수 없습니다.");
    
    private String message;
    
    ErrorMessages(String message) {
        this.message = message;
    }
    
    public String message() {
        return message;
    }
}
