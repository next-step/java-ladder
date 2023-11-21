package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Line {
    private final List<Boolean> points = new ArrayList<>();

    public Line(int countOfPerson) {
        IntStream.range(0, countOfPerson - 1)
                .forEach(idx -> points.add(false));
    }

    public List<Boolean> points() {
        return new ArrayList<>(points);
    }
}