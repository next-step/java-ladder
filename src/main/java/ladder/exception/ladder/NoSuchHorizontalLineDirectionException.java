package ladder.exception.ladder;

import ladder.exception.LadderException;

public class NoSuchHorizontalLineDirectionException extends LadderException {
    public NoSuchHorizontalLineDirectionException() {
        super("사다리가 존재하지 않습니다.");
    }
}
