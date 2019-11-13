package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Lines {
    private List<Line> lines;

    public Lines(int countOfLine, int countOfPerson) {
        lines = createLines(countOfLine, countOfPerson);
    }

    public List<Line> createLines(int countOfLine, int countOfPerson) {
        lines = new ArrayList<>();
        for (int i = 0; i < countOfLine; i++) {
            Line line = new Line(countOfPerson);
            lines.add(line);
        }
        return new ArrayList<>(lines);
    }

    public List<Line> getLadderLines() {
        return new ArrayList<>(lines);
    }
}
