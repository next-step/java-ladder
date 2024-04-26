package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final List<Line> lines;
    private final int countOfPeople;

    public Ladder(int countOfPeople) {
        this(countOfPeople, new ArrayList<>());
    }

    public Ladder(int countOfPeople, List<Line> lines) {
        this.countOfPeople = countOfPeople;
        this.lines = lines;
    }

    public Ladder create(int height, int countOfPerson) {
        if (height <= 0) {
            throw new IllegalArgumentException("사다리 높이는 1 이상이어야 합니다.");
        }
        if (countOfPerson <= 0) {
            throw new IllegalArgumentException("사람 수는 1 이상이어야 합니다.");
        }
        for (int i = 0; i < height; i++) {
            Line line = new Line(countOfPerson);
            line.create();
            lines.add(line);
        }
        return new Ladder(countOfPeople, lines);
    }

    public int move(int position) {
        int result = position;
        for (Line line : lines) {
            result = line.move(result);
        }
        return result;
    }

    public LadderResult game() {
        LadderResult ladderResult = new LadderResult();
        for (int i = 0; i < countOfPeople; i++) {
            ladderResult.add(move(i));
        }
        return ladderResult;
    }

    public List<Line> getLines() {
        return lines;
    }
}
