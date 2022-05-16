package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Line {
    private static final String STICK = "|";
    private static final Random RANDOM = new Random();
    private static final String LINE_SEPARATOR = System.getProperty("line.separator");

    private final Points points;

    public Line(Members members) {
        this(toPoints(members));
    }

    Line(List<Boolean> points) {
        this.points = new Points(points);
    }

    private static List<Boolean> toPoints(Members members) {
        List<Boolean> points = new ArrayList<>();
        IntStream.rangeClosed(0, members.size())
                .forEach(i -> setPoints(points, i));

        return points;
    }

    private static void setPoints(List<Boolean> points, int i) {
        if (previousHasEdge(points, i)) {
            points.add(false);
            return;
        }

        points.add(RANDOM.nextBoolean());
    }

    private static boolean previousHasEdge(List<Boolean> points, int i) {
        if (points.isEmpty()) {
            return false;
        }

        return points.get(i - 1);
    }

    public String getPoint() {
        return this.points.getPoint() +
                STICK +
                LINE_SEPARATOR;
    }
}
