package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Line {

    private static final int BEGIN_INDEX = 0;
    private static final boolean EMPTY_POINT = false;
    private static final double HALF = 0.5;

    private final List<Boolean> horizontalLines;

    public Line(List<Boolean> horizontalLines) {
        this.horizontalLines = horizontalLines;
    }

    public Line(int countOfPerson) {
        this(generateLine(countOfPerson));
    }

    public static List<Boolean> generateLine(int countOfPerson) {
        List<Boolean> horizontalLines = new ArrayList<>();

        IntStream.range(BEGIN_INDEX, countOfPerson - 1)
                .forEach(idx -> horizontalLines.add(createPoint(idx, horizontalLines)));
        return horizontalLines;
    }

    private static Boolean createPoint(int idx, List<Boolean> horizontalLines) {
        if (BEGIN_INDEX == idx) {
            return isCurrPointNonEmpty();
        }
        return isPrevPointEmpty(idx, horizontalLines) && isCurrPointNonEmpty();
    }

    private static boolean isPrevPointEmpty(int idx, List<Boolean> horizontalLines) {
        return EMPTY_POINT == horizontalLines.get(idx - 1);
    }

    private static boolean isCurrPointNonEmpty() {
        return HALF < Math.random();
    }

    public List<Boolean> value() {
        return horizontalLines;
    }

    @Override
    public String toString() {
        return "Line{" +
                "horizontalLines=" + horizontalLines +
                '}';
    }
}
