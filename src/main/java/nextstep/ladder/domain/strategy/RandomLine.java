package nextstep.ladder.domain.strategy;

import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Point;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomLine implements LineStrategy {
    private static final int FIRST_LINE_INDEX = 0;

    @Override
    public Line createLine(int personCount) {
        int lineCount = personCount - 1;
        int lastIndex = lineCount - 1;
        List<Point> list = new ArrayList<>();
        boolean oneLeftPointnHasLine = false;
        for (int index = 0; index < lineCount; index++) {
            if (index == FIRST_LINE_INDEX) {
                addRandomPoint(list);
                continue;
            }

            if (index == lastIndex) {
                addEmptyPoint(list);
                continue;
            }

            oneLeftPointnHasLine = lineHasPoint(list, index - 1);
            if(oneLeftPointnHasLine) {
                addEmptyPoint(list);
                continue;
            }

            addRandomPoint(list);
        }

        return new Line(list);
    }

    private static void addRandomPoint(List<Point> list) {
        addPoint(list, randomPoint());
    }

    private static void addEmptyPoint(List<Point> list) {
        addPoint(list, Boolean.FALSE);
    }

    private static void addPoint(List<Point> list, boolean point) {
        list.add(new Point(point));
    }

    private static boolean randomPoint() {
        return new Random().nextBoolean();
    }

    private static boolean lineHasPoint(List<Point> list, int index) {
        return list.get(index).isPoint();
    }
}
