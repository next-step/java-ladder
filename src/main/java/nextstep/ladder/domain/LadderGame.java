package nextstep.ladder.domain;

import java.util.List;

public class LadderGame {
    private final Ladder ladder;
    private final Names names;

    public LadderGame(int height, List<Name> names) {
        this.ladder = new Ladder(height, names.size());
        this.names = new Names(names);
    }

    public LadderGame(int height, List<Name> names, LineStrategy lineStrategy) {
        this.ladder = new Ladder(height, names.size(), lineStrategy);
        this.names = new Names(names);
    }

    public List<List<Boolean>> getLadder() {
        return ladder.getLines();
    }

    public List<String> getNames() {
        return names.getNames();
    }
}
