package ladder.domain;

import java.util.List;

public class Ladder {

    private Lines lines;
    private Floor floor;

    private Ladder(int height, int countOfPlayer) {

        Lines lines = new Lines(height, countOfPlayer);
        Floor newFloor = new Floor(height);

        this.floor = newFloor;
        this.lines = lines;
    }

    public static Ladder of(int height, int countOfPlayer) {
        Ladder ladder = new Ladder(height, countOfPlayer);

        if (!ladder.lines.hasAtLeastOneBridge(countOfPlayer)) {
            return Ladder.of(height, countOfPlayer);
        }

        return ladder;
    }

    public List<Line> getLines() {
        return lines.getLines();
    }
}
