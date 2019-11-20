package nextstep.ladder.domain;

import java.util.*;

public class Game {

    private final int STEP_MIN_NUM = 1;

    private Spots spots;
    private Ladder ladder;

    public Game(Spots spots, int totalStep) {
        if (!isValidTotalStep(totalStep)) {
            throw new IllegalArgumentException("사다리 높이는 1층 이상이어야 합니다");
        }
        this.spots = spots;
        this.ladder = new Ladder(totalStep, spots.getSpotSize());
    }

    private boolean isValidTotalStep(int totalStep) {
        return (totalStep >= STEP_MIN_NUM);
    }

    public Map<String, String> execute() {
        return spots.useLadder(ladder);
    }

    public Ladder getLadder() {
        return ladder;
    }
}
