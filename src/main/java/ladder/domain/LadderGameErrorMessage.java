package ladder.domain;

import static ladder.domain.LadderGameConfig.MIN_LADDER_HEIGHT;
import static ladder.domain.LadderGameConfig.PLAYER_NAME_MAX_LENGTH;

public enum LadderGameErrorMessage {

    ILLEGAL_MAX_HEIGHT(0, "최대 사다리 높이를 숫자로 입력하세요."),
    ILLEGAL_MAX_PLAYER_NAME(1, "참여할 사람의 이름은 최대 "+PLAYER_NAME_MAX_LENGTH+" 글자 입니다."),
    OVER_MIN_HEIGHT(2, "최소 사다리 높이는 "+MIN_LADDER_HEIGHT+" 입니다.");

    private int code;
    private String errorMessage;

    LadderGameErrorMessage(int code, String errorMessage){
        this.code = code;
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage(){
        return errorMessage;
    }
}
