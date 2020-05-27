package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Line {
    private List<Boolean> points = new ArrayList<>();

    public Line(int countOfPerson) {
        IntStream.range(0, countOfPerson)
                .forEach(num -> points.add(false));
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
