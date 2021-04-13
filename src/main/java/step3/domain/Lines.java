package step2.domain;

import step2.domain.Line;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lines {

    private final List<Line> lines;

    public Lines(int height, int countOfPerson) {
        this.lines = createLines(height, countOfPerson);
    }

    public Lines(List<Line> lines) {
        this.lines = lines;
    }

    private List<Line> createLines(int height, int countOfPerson) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(new Line(countOfPerson));

        }
        return lines;
    }

    public int eachPositionResult(int position) {
        for (Line line : lines) {
            position = line.move(position);
        }

        return position;
    }

    public List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

}
