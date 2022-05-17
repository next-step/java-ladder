package nextstep.ladder.domain;

import nextstep.ladder.exception.LadderException;
import nextstep.ladder.exception.LadderExceptionCode;

public class Player {
    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 5;
    private final String name;

    public Player(String name) {
        if (name.length() < MIN_LENGTH || name.length() > MAX_LENGTH) {
            throw new LadderException(LadderExceptionCode.INVAILD_NAME_LENGTH);
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
