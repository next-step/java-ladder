package nextstep.ladder.domain;

import java.util.List;

public class LadderGame {

    private final List<Name> names;

    private final Ladder ladder;

    public LadderGame(List<Name> names, Ladder ladder) {
        this.names = names;
        this.ladder = ladder;
    }

    public List<Name> getNames() {
        return names;
    }

    public Ladder getLadder() {
        return ladder;
    }
}
