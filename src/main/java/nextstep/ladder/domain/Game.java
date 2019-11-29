package nextstep.ladder.domain;

import java.util.*;

public class Game {

    private Spots spots;
    private Ladder ladder;

    public Game(Spots spots, int totalStep) {
        this.spots = spots;
        this.ladder = new Ladder(totalStep, spots.getSpotSize());
    }

    public Map<String, String> execute() {
        return spots.useLadder(ladder);
    }

    public Ladder getLadder() {
        return ladder;
    }
}
