package ladder;

import ladder.util.RandomValueGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Line {
    private final List<Boolean> points = new ArrayList<>();

    public Line(int countOfPerson) {
        IntStream.range(0, countOfPerson - 1)
                .mapToObj(i -> isInValidPosition(i) ? false : RandomValueGenerator.generate())
                .forEach(points::add);
    }

    private boolean isInValidPosition(int position) {
        return isLeftTrue(position);
    }

    private boolean isLeftTrue(int position) {
        return (position - 1 >= 0 && points.get(position - 1));
    }


    public List<Boolean> getPoints() {
        return points;
    }
}
