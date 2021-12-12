package nextstep.ladder.model;

import nextstep.ladder.generator.LineGenerator;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private static final String BLANK_LINE = "     ";
    private static final String EXIST_LINE = "-----";
    private static final String LADDER_COLUMN = "|";
    private static final int ONE = 1;

    private final List<Boolean> points = new ArrayList<>();

    public Line(int countOfPerson, LineGenerator generator) {
        points.add(generator.generate(null));
        for (int i = ONE; i < countOfPerson - ONE; i++) {
            Boolean prevPoint = points.get(i - ONE);
            points.add(generator.generate(prevPoint));
        }
    }

    private String isLine(boolean point) {
        return point ? EXIST_LINE : BLANK_LINE;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(BLANK_LINE + LADDER_COLUMN);
        points.forEach(point -> builder.append(isLine(point)).append(LADDER_COLUMN));
        return builder.toString();
    }
}
