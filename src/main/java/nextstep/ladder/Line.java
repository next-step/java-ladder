package nextstep.ladder;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Line {
    private final Random random = new Random();
    private final List<Boolean> points;

    public Line(int width) {
        this.points = generatePoints(width);
        eraseDuplicate();
    }

    private List<Boolean> generatePoints(int width) {
        return IntStream.rangeClosed(1, width - 1)
                .mapToObj(i -> makeBridge())
                .collect(Collectors.toList());
    }

    private boolean makeBridge() {
        return random.nextBoolean();
    }

    public int size() {
        return points.size();
    }

    public boolean hasDuplicate() {
        for (int i = 1; i < points.size(); i++) {
            if (points.get(i - 1) && points.get(i)) {
                return true;
            }
        }
        return false;
    }

    private void eraseDuplicate() {
        for (int i = 1; i < points.size(); i++) {
            if (points.get(i - 1) && points.get(i)) {
                points.set(i, false);
            }
        }
    }

    void print() {
        points.forEach(System.out::println);
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
