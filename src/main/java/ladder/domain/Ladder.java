package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ladder {
    public static final int START_COLUMN = 0;

    private List<LadderLine> ladderLines;

    private Ladder(int row, int countOfPerson) {
        ladderLines = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            ladderLines.add(LadderLine.create(countOfPerson));
        }
    }

    public static Ladder create(int row, int countOfPerson) {
        return new Ladder(row, countOfPerson);
    }

    public static Ladder create(LadderOption ladderOption, Attendees attendees) {
        return new Ladder(ladderOption.height(), attendees.size());
    }

    public int endpoint(int countOfPerson) {
        return follow(countOfPerson, START_COLUMN);
    }

    private int follow(int column, int row) {
        LadderLine ladderLine = ladderLines.get(row);

        column = ladderLine.move(column);
        row = row + 1;

        if(row < ladderLine.size() + 1) {
            return this.follow(column, row);
        }
        return column;
    }

    public int size() {
        return ladderLines.size();
    }

    @Override
    public String toString() {
        return ladderLines.stream().map(LadderLine::toString).collect(Collectors.joining("\n"));
    }
}
