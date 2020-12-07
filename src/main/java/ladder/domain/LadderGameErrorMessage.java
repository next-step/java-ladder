package ladder.domain;

import static ladder.domain.LadderGameConfig.MIN_LADDER_HEIGHT;
import static ladder.domain.LadderGameConfig.PLAYER_NAME_MAX_LENGTH;

public enum LadderGameErrorMessage {

    ILLEGAL_MAX_HEIGHT(0, "최대 사다리 높이를 숫자로 입력하세요."),
    ILLEGAL_MAX_PLAYER_NAME(1, "참여할 사람의 이름은 최대 "+PLAYER_NAME_MAX_LENGTH+" 글자 입니다."),
    OVER_MIN_HEIGHT(2, "최소 사다리 높이는 "+MIN_LADDER_HEIGHT+" 입니다."),
    ILLEGAL_LINE_POINTS(3, "사다리 가로라인은 겹칠 수 없습니다."),
    ILLEGAL_AWARDS_COUNT(4, "사다리 갯수만큼 실행결과를 입력하세요.");

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
