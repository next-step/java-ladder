package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ladder {
    private final List<Line> lines;

    private Ladder(int height, int countOfPerson) {
        this.lines = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            lines.add(new Line(countOfPerson));
        }
    }

    public static Ladder getInstance(int height, int countOfPerson) {
        return new Ladder(height, countOfPerson);
    }

    public int getHeight() {
        return this.lines.size();
    }

    public List<Line> getLines() {
        return lines.stream()
                .map(Line::getNewInstance)
                .collect(Collectors.toList());
    }
}
