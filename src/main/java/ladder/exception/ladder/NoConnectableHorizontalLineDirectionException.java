package ladder.exception.ladder;

import ladder.exception.LadderException;

public class NoConnectableHorizontalLineDirectionException extends LadderException {
    public NoConnectableHorizontalLineDirectionException() {
        super("연결 가능한 사다리가 존재하지 않습니다.");
    }
}
