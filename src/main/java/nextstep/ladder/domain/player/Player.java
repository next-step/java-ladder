package nextstep.ladder.domain.player;

import nextstep.ladder.domain.ladder.ColumnIndex;

public class Player {
    private final Name name;
    private final ColumnIndex index;

    public Player(String name, int index) {
        this(new Name(name), new ColumnIndex(index));
    }

    public Player(Name name, ColumnIndex index) {
        this.name = name;
        this.index = index;
    }

    public Name name() {
        return this.name;
    }

}
