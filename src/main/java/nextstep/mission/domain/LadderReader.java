package nextstep.mission.domain;

public class LadderReader {

    private Ladder ladder;
    private int cursor;

    public LadderReader(Ladder ladder) {
        this.ladder = ladder;
        this.cursor = 0;
    }

    public boolean hasNext() {
        return this.cursor < this.ladder.getHeight();
    }

    public Line getLine() {
        if (!hasNext()) {
            return null;
        }

        return ladder.getLine(this.cursor++);
    }
}
