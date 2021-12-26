package nextstep.ladder.model;

import nextstep.ladder.common.Name;

public class Result extends Name {

    private final Index index;

    public Result(String name, Index index) {
        super(name);
        this.index = index;
    }

    public boolean equalsIndex(Index index) {
        return this.index.equals(index);
    }
}
