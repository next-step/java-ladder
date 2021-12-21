package nextstep.ladder.model;

import nextstep.ladder.common.Name;

public class Player extends Name {

    private final Index index;

    public Player(String name) {
        super(name);
        this.index = new Index(0);
    }

    public Player(String name, int index) {
        super(name);
        this.index = new Index(index);
    }

    public Index getIndex() {
        return index;
    }
}
