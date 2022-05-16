package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Line {
    private static final String STICK = "|";
    private static final Random RANDOM = new Random();
    private static final String LINE_SEPARATOR = System.getProperty("line.separator");
    private static final String EDGE = "-----";
    private static final String EMPTY = "     ";

    private final List<Boolean> points;

    public Line(Members members) {
        this(toPoints(members));
    }

    Line(List<Boolean> points) {
        this.points = points;
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
        StringBuilder stringBuilder = new StringBuilder();
        this.points.stream()
                .map(this::getEdgeOrEmpty)
                .forEach(stringBuilder::append);

        stringBuilder.append(STICK);
        stringBuilder.append(LINE_SEPARATOR);

        return stringBuilder.toString();
    }

    private String getEdgeOrEmpty(Boolean point) {
        if (point) {
            return STICK + EDGE;
        }

        return STICK + EMPTY;
    }
}
