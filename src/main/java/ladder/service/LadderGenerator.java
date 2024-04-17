package ladder.service;

import ladder.domain.Ladder;
import ladder.domain.Line;

import java.util.ArrayList;
import java.util.List;

public class LadderGenerator {
    public static Ladder generateLadder(int height, int width) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(LadderGenerator.generateLine(width));
        }

        return new Ladder(lines);
    }

    private static Line generateLine(int width) {
        RandomGenerator generator = new RandomGenerator();

        return new Line(generator.getRandomBooleans(width));
    }
}
