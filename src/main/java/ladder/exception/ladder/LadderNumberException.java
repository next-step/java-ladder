package ladder.exception.ladder;

import ladder.exception.LadderException;

public class LadderNumberException extends LadderException {
    public LadderNumberException(int type) {
        super("사다리 타입 " + type + "이 존재하지 않습니다.");
    }
}
