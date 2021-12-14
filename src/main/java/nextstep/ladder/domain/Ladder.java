package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Ladder {

    private static final int START_NUMBER = 0;

    private final List<Line> lines = new ArrayList<>();

    private Ladder(PositiveNumber height, int participantsCount, Random random) {
        valid(participantsCount);

        IntStream.range(START_NUMBER, height.getNumber())
            .forEach(index -> lines.add(new Line(participantsCount - 1, random)));
    }

    public static Ladder create(PositiveNumber height, int participantsCount) {
        return new Ladder(height, participantsCount, new Random());
    }

    public static Ladder create(PositiveNumber height, int participantsCount, Random random) {
        return new Ladder(height, participantsCount, random);
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }

    public Position execute(Position position) {
        Position tempPosition = position;

        for (Line line : lines) {
            tempPosition = tempPosition.move(line);
        }

        return tempPosition;
    }

    private void valid(int participantsCount) {
        if (participantsCount < 0) {
            throw new IllegalArgumentException("참석자의 수는 0명 아래일 수 없어요.");
        }
    }

    @Override
    public String toString() {
        return "Ladder{" +
            "lines=" + lines +
            '}';
    }


}
