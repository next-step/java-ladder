package ladder.domain;

import ladder.view.exception.InvalidLadderHeightException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ladder {
    private static final int LINE_COUNT_MIN = 1;

    private List<Line> lines;

    public Ladder(List<Line> lines) {
        this.lines = lines.stream()
                .map(Line::getNewInstance)
                .collect(Collectors.toList());
    }

    public static Ladder getInstance(int height, int width) {
        if (height < LINE_COUNT_MIN) {
            throw new InvalidLadderHeightException();
        }

        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(Line.getNewInstance(LineGenerator.generateRandomPoints(width)));
        }

        return new Ladder(lines);
    }

    public static Ladder getInstance(List<Line> lines) {
        return new Ladder(lines);
    }

    public List<Line> getLines() {
        return lines.stream()
                .map(Line::getNewInstance)
                .collect(Collectors.toList());
    }

    public boolean isHeightSame(int height) {
        return height == lines.size();
    }

    public int getResultIndex(int personIndex) {
        for (Line line : lines) {
            personIndex = line.movePosition(personIndex);
        }

        return personIndex;
    }
}
