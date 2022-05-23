package nextstep.ladder.domain;

import nextstep.ladder.exception.LadderException;
import nextstep.ladder.exception.LadderExceptionCode;

public class Player {
    private static final int MAX_LENGTH = 5;
    private final String name;

    public Player(String name) {
        if (isEmpty(name)) {
            throw new LadderException(LadderExceptionCode.INVALID_NAME_FORMAT, name);
        }

        if (name.length() > MAX_LENGTH) {
            throw new LadderException(LadderExceptionCode.INVAILD_NAME_LENGTH, String.valueOf(name.length()));
        }
        this.name = name;
    }

    private boolean isEmpty(String name) {
        return name == null || name.isBlank();
    }

    public String getName() {
        return name;
    }
}
