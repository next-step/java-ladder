package nextstep.ladder.domain;

import nextstep.ladder.support.DefaultRandomBoolean;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Line> lines;

    public Ladder(int countOfNumber, int height) {
        lines = IntStream.range(0, height)
                         .mapToObj(h -> new Line(countOfNumber, new DefaultRandomBoolean()))
                         .collect(Collectors.toList());
    }

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public List<Line> lines() {
        return Collections.unmodifiableList(this.lines);
    }

    public int move(int currentPosition) {
        int position = currentPosition;
        for (Line line : lines) {
            position = line.position(position);
        }
        return position;
    }

    @Override
    public String toString() {
        return "Ladder{" +
                "lines=" + lines +
                '}';
    }
}
