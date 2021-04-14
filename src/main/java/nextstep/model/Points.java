package nextstep.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Points {
    private final List<Boolean> points;

    public Points(int countOfPerson) {
        this.points = new ArrayList<>();
        IntStream.range(0, countOfPerson)
                .forEach(num -> points.add(false));
    }

    public void add(boolean point) {
        points.add(point);
    }

    public int size() {
        return this.points.size();
    }

    public void markOne(int target, boolean bool) {
        points.set(target, bool);
    }

    public boolean get(int i) {
        return this.points.get(i);
    }
}
