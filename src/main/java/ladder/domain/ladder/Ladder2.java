package ladder.domain.ladder;

import ladder.vo.LadderLocation;

public class Ladder2 {
    private final Lines2 lines;

    public Ladder2(Lines2 lines) {
        this.lines = lines;
    }

    int getResult(int index) {
        LadderLocation location = new LadderLocation(index, lines.getHeight());

        LadderLocation resultLocation = crossDownToBottom(location);
        return resultLocation.getIndex();
    }

    private LadderLocation crossDownToBottom(LadderLocation location) {
        while (!location.isBottom()) {
            location = this.lines.cross(location);
        }

        return location;
    }

    @Override
    public String toString() {
        return this.lines.toString();
    }
}
