package ladder.domain;

import ladder.engine.Ladder;
import ladder.engine.LineCreator;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JerryLadderCreator {
    public static final int MIN_HEIGHT = 1;
    LineCreator lineCreator;

    public JerryLadderCreator(LineCreator lineCreator) {
        this.lineCreator = lineCreator;
    }

    Ladder create(int width, int height) {
        validateHeight(height);

        return new JerryLadder(Stream.generate(() -> lineCreator.create(width))
                .limit(height)
                .collect(Collectors.toCollection(ArrayList::new)));
    }

    private static void validateHeight(int height) {
        if (height < MIN_HEIGHT) {
            throw new IllegalArgumentException("사다리 높이는 " + MIN_HEIGHT + " 이상이어야 합니다.");
        }
    }
}
