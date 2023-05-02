package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Line {
    private final List<Boolean> points = new ArrayList<>();

    public Line(int countOfMember) {
        IntStream.range(0, countOfMember - 1).forEach(i -> this.addPoint(i, new Random().nextBoolean()));
    }

    public Line(Boolean... booleans) {
        IntStream.range(0, booleans.length).forEachOrdered(i -> this.addPoint(i, booleans[i]));
    }

    private void addPoint(int index, boolean isPoint) {
        if (this.canNotHavePoint(index)) {
            points.add(false);
            return;
        }

        points.add(isPoint);
    }

    private boolean canNotHavePoint(int index) {
        return index == 0 || points.get(index - 1);
    }


    public List<Boolean> points() {
        return Collections.unmodifiableList(this.points);
    }
}
