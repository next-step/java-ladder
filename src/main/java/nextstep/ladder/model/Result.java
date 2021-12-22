package nextstep.ladder.model;

import nextstep.ladder.common.Name;

public class Result extends Name {

    private final Index index;

    public Result(String name) {
        super(name);
        this.index = new Index();
    }

    public Result(String name, Index index) {
        super(name);
        this.index = index;
    }

    public Index getIndex() {
        return index;
    }
}
