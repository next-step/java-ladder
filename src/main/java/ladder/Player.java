package ladder;

import ladder.exception.TooLongNameException;

public class Player {
    private Name name;

    public Player(String name) throws TooLongNameException {
        this.name = new Name(name);
    }
}
