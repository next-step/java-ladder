package ladder.exception.person;

import ladder.exception.LadderException;

public class PeopleSizeException extends LadderException {

    public PeopleSizeException() {
        super("People의 크기는 2 이상이어야 합니다.");
    }
}
