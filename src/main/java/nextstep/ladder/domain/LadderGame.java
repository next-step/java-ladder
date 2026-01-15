package nextstep.ladder.domain;

public class LadderGame {
    private final Names names;
    private final Ladder ladder;

    public LadderGame(String input, int height) {
        this(new Names(input), new Ladder(height, new Names(input).size()));
    }

    public LadderGame(Names names, Ladder ladder) {
        this.names = names;
        this.ladder = ladder;
    }

    public Names getNames() {
        return names;
    }

    public Ladder getLadder() {
        return ladder;
    }
}
