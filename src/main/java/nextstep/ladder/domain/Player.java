package nextstep.ladder.domain;

import nextstep.ladder.exception.LadderException;

public class Player {
    private final String name;

    public Player(String name) {
        if (name.length() < 1 || name.length() > 5) {
            throw new LadderException();
        }
        this.name = name;
    }
}
