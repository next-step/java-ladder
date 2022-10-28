package ladder.exception.ladder;

import ladder.exception.LadderException;

public class EscapeLadderLinesException extends LadderException {
    public EscapeLadderLinesException() {
        super("사다리 너비를 벗어났습니다.");
    }
}
