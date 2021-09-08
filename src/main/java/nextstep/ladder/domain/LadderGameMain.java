package nextstep.ladder.domain;

public class LadderGameMain {

    private final Ladder ladder;

    public LadderGameMain(LadderGameSettings settings) {
        this.ladder = Ladder.from(settings);
    }

    public void playGame() {

    }

    public Ladder getLadder() {
        return ladder;
    }
}
