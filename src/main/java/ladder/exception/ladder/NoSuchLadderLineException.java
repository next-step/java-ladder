package ladder.exception.ladder;

import ladder.exception.LadderException;

public class NoSuchLadderLineException extends LadderException {
    public NoSuchLadderLineException() {
        super("LadderLine이 존재하지 않습니다.");
    }
}
