package ladder.domain;

public enum LadderErrorMessage {

    ILLEGAL_MAX_HEIGHT(0, "최대 사다리 높이를 숫자로 입력하세요.");

    private int code;
    private String errorMessage;

    LadderErrorMessage(int code, String errorMessage){
        this.code = code;
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage(){
        return errorMessage;
    }
}
