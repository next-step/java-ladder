package nextstep.ladder.domain.ladder;

import java.util.List;

public class Ladder {

    private final int MINIMUM_LINE_SIZE = 1;
    private final Lines lines;

    public Ladder(Height height, int sizeOfPerson, DirectionPredicate predicate) {
        this.lines = new Lines(height, sizeOfPerson, predicate);
    }

    public List<Line> getLines() {
        return lines.getLines();
    }

    public int findDestinationPosition(int startPoint) {
        return lines.move(startPoint);
    }

    public int getHeight() {
        return getLines().size();
    }

    public int getMaxPoint() {
        if (getLines().size() >= MINIMUM_LINE_SIZE) {
            return getLines().get(MINIMUM_LINE_SIZE).sizeOfPositions();
        }
        throw new RuntimeException("Max Point is less than 1");
    }
}
