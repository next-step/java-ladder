package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private int height;
    private ArrayList<Line> lines;

    private Ladder(int height) {
        this.height = height;
        lines = new ArrayList<>();
    }

    public static Ladder from(int height) {
        return new Ladder(height);
    }

    public List<Line> generateLadder(People people) {
        for (int i = 0; i < height; i++) {
            lines.add(Line.from(people.peopleCount()));
        }
        return lines;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Line line : lines) {
            stringBuilder.append(line.toString()+"\n");
        }
        return stringBuilder.toString();
    }
}