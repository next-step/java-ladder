package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final List<Line> lines = new ArrayList<>();

    public Ladder(int height, int countOfPerson) {
        for (int i = 0; i < height; i++) {
            lines.add(new Line(countOfPerson));
        }
    }

    public void generateLines() {
        lines.forEach(Line::generateConnection);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        lines.forEach(line -> stringBuilder.append(line.toString()).append("\n"));
        return stringBuilder.toString();
    }
}
