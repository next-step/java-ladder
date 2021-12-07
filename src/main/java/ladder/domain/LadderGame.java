package ladder.domain;

public class LadderGame {

    private final Names names;
    private final Ladder ladder;

    public LadderGame(String names, int height) {
        this.names = new Names(names);
        this.ladder = new Ladder(this.names, height);
    }

    public Names getNames() {
        return names;
    }

    public Ladder getLadder() {
        return ladder;
    }

}
