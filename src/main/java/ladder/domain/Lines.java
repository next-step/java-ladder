package ladder.domain;

import ladder.view.exception.InvalidLadderHeightException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lines {
    private static final int LINE_COUNT_MIN = 1;

    private List<Line> lines;

    public Lines(List<Line> lines) {
        this.lines = lines;
    }

    public static Lines getInstance(int height, int width) {
        if (height < LINE_COUNT_MIN) {
            throw new InvalidLadderHeightException();
        }

        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(Line.getNewInstance(LineGenerator.generateRandomPoints(width)));
        }

        return new Lines(lines);
    }

    public List<Line> getLines() {
        return lines.stream()
                .map(Line::getNewInstance)
                .collect(Collectors.toList());
    }

    public boolean isHeightSame(int height) {
        return height == lines.size();
    }
}
