package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Ladder {

    private final List<Line> lines = new ArrayList<>();

    private Ladder(PositiveNumber height, int participantsCount) {
        PositiveNumber pointCount = PositiveNumber.create(participantsCount - 1);

        IntStream.range(0, height.getNumber())
            .forEach(i -> lines.add(new Line(pointCount, new Random())));
    }

    public static Ladder create(PositiveNumber height, int participantsCount) {
        return new Ladder(height, participantsCount);
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }

    @Override
    public String toString() {
        return "Ladder{" +
            "lines=" + lines +
            '}';
    }
}
