package nextstep.domain;

import java.util.ArrayList;
import java.util.List;

public class Lines {

    private final List<Line> lines;

    public Lines(int peopleCount, int height) {
        this.lines = createLines(peopleCount, height);
    }

    public Lines(List<Line> lines) {
        this.lines = lines;
    }

    private List<Line> createLines(int peopleCount, int height) {
        List<Line> tempLines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            tempLines.add(new Line(new LineRandom(), peopleCount));
        }
        return tempLines;
    }

    public int findDestination(int start) {
        for (Line line : lines) {
            start += line.getDirection(start).getValue();
        }
        return start;
    }

    public List<Line> getLines() {
        return lines;
    }
}
