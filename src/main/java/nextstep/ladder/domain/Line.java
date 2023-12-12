package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Line {
    private final List<Boolean> points = new ArrayList<>();

    public Line(int countOfPerson) {
        this(IntStream.range(0, countOfPerson)
                .mapToObj(i -> Boolean.FALSE)
                .collect(Collectors.toList())
        );
    }

    public Line(List<Boolean> points) {
        validateExistSequentialLine(points);
        this.points.addAll(points);
    }

    private static void validateExistSequentialLine(List<Boolean> points) {
        for (int i = 1; i < points.size(); i++) {
            if (points.get(i - 1) && points.get(i)) {
                throw new IllegalArgumentException("라인은 연속으로 겹치면 안됩니다.");
            }
        }
    }
}
