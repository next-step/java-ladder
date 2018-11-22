package domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final List<Line> lines;

    private Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder from(List<Line> lines) {
        return new Ladder(lines);
    }

    public static Ladder of(PositiveNumber height, Participants participants) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height.value(); i++) {
            lines.add(Line.initialize(participants, new RandomPointGenerator()));
        }

        return new Ladder(lines);
    }

    public int goingDown(int index) {
        for (Line line : lines) {
            index = line.move(index);
        }

        return index;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        lines.forEach(line -> stringBuilder.append(line.toString()).append("\n"));
        return stringBuilder.toString();
    }
}
