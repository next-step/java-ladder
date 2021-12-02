package step2.domain;

import step2.strategy.LineCreateStrategy;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<Line> lines = new ArrayList<>();

    private Ladder(int participantCount, int height, LineCreateStrategy createStrategy) {
        for (int count = 0; count < height; count++) {
            lines.add(Line.create(participantCount, createStrategy));
        }
    }

    public static Ladder create(int participantCount, int height, LineCreateStrategy createStrategy) {
        return new Ladder(participantCount, height, createStrategy);
    }

    public List<Line> getLines() {
        return lines;
    }
}
