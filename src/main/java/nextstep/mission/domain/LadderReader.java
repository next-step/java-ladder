package nextstep.mission.domain;

public class LadderReader {

    private Ladder ladder;
    private int cursor;

    public LadderReader(Ladder ladder) {
        this.ladder = ladder;
        this.cursor = 0;
    }

    public boolean hasNext() {
        return !this.ladder.checkHeight(this.cursor);
    }

    public Line getLine() {
        return ladder.getLine(this.cursor++);
    }
}
