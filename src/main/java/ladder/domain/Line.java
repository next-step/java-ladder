package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Line {
    public static final String POINT_TRUE = "-----|";
    public static final String POINT_FALSE = "     |";
    private static final Random RANDOM = new Random();

    private List<Boolean> points;

    private Line(int countOfPerson) {
        this.points = createLine(countOfPerson);
    }

    public static Line create(int countOfPerson) {
        return new Line(countOfPerson);
    }

    public String drawLadderLine() {
        String ladderLine = "";
        for (boolean point : points) {
            ladderLine += point ? POINT_TRUE : POINT_FALSE;
        }
        return ladderLine;
    }

    boolean checkLineOverlap(Boolean point) {
        if (point) {
            return false;
        }
        return RANDOM.nextBoolean();
    }

    private List<Boolean> createLine(int countOfPerson) {
        List<Boolean> points = new ArrayList<>();
        IntStream.rangeClosed(0, countOfPerson)
                .mapToObj(i -> false)
                .reduce((point, base) -> {
                    points.add(point);
                    return checkLineOverlap(point);
                });
        return points;
    }
}
