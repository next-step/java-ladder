package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Ladder {

    private final List<Line> lines = new ArrayList<>();

    public Ladder(int height, int participantsCount) {
        IntStream.range(0, height)
            .forEach(i -> lines.add(new Line(participantsCount, new Random())));
    }

    public static Ladder create(int height, int participantsCount) {
        return new Ladder(height, participantsCount);
    }

    @Override
    public String toString() {
        return "Ladder{" +
            "lines=" + lines +
            '}';
    }
}
