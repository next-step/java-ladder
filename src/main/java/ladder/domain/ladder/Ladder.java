package ladder.domain.ladder;

import ladder.vo.LadderLocation;

public class Ladder {
    private final Lines lines;

    public Ladder(Lines lines) {
        this.lines = lines;
    }

    public int getResultIndex(int index) {
        LadderLocation location = new LadderLocation(index, lines.getHeight());
        LadderLocation resultLocation = crossDownToBottom(location);
        return resultLocation.getIndex();
    }

    public int getWidth() {
        return this.lines.getSize() - 1;
    }

    public int getHeight() {
        return this.lines.getHeight();
    }

    @Override
    public String toString() {
        return this.lines.toString();
    }

    private LadderLocation crossDownToBottom(LadderLocation location) {
        while (!location.isBottom()) {
            location = this.lines.cross(location);
        }

        return location;
    }
}
