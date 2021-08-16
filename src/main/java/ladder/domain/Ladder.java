package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<Line> lines;

    private Ladder(int ladderMaxLength, int countOfPerson) {
        this.lines = new ArrayList<>();
        for (int i = 0; i < ladderMaxLength; i++) {
            this.lines.add(Line.of(countOfPerson));
        }
    }

    public static Ladder of(int ladderMaxLength, int countOfPerson) {
        return new Ladder(ladderMaxLength, countOfPerson);
    }

    public int getLadderWidth() {
        return lines.stream()
                .map(Line::getSize)
                .findFirst()
                .orElse(0);

    }

    public int getLadderHeight() {
        return lines.size();
    }

    public boolean havePoints(int row, int column) {
        Line currentLine = lines.get(row);
        return currentLine.havePoints(column);
    }
}
