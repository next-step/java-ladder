package ladder.exception.ladder;

import ladder.exception.LadderException;

public class LadderWidthBoundException extends LadderException {
    public LadderWidthBoundException(int ladderWidthMin) {
        super("사다리 너비는 " + ladderWidthMin + "이상이어야 합니다.");
    }
}
