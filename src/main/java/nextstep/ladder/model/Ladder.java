package nextstep.ladder.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private static final int START_INDEX = 0;

    private final List<Line> ladder;

    public Ladder(int height, int participant) {
        this(create(height, participant));
    }

    public Ladder(List<Line> ladder) {
        this.ladder = ladder;
    }

    private static List<Line> create(int height, int participant) {
        return IntStream.range(START_INDEX, height)
                .mapToObj(i -> new Line(participant))
                .collect(Collectors.toList());
    }

    public List<Line> lines() {
        return ladder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ladder ladder1 = (Ladder) o;
        return Objects.equals(ladder, ladder1.ladder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ladder);
    }

    @Override
    public String toString() {
        return "Ladder{" +
                "ladder=" + ladder +
                '}';
    }
}
