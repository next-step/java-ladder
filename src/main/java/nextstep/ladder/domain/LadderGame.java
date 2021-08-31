package nextstep.ladder.domain;

public class LadderGame {
    private Ladder ladder;
    private int index;

    public LadderGame(int index, Ladder ladder) {
        this.ladder = ladder;
        this.index = index;

    }

    public String start() {
        return ladder.search(index);
    }
}
