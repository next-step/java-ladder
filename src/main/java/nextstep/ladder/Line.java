package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Line {
    private static final Random RANDOM = new Random();
    private static final String LINE_DELIMITER = "|";

    private List<Cross> crosses;

    public Line(int countOfPerson) {
        createCrosses(countOfPerson);
    }

    public Line(List<Cross> crosses) {
        this.crosses = crosses;
    }

    private void createCrosses(int countOfPerson) {
        crosses = new ArrayList<>();

        Point point = Point.first(RANDOM.nextBoolean());
        for (int i = 0; i < countOfPerson; i++) {
            point = updatePoint(i, countOfPerson, point);
            crosses.add(new Cross(i, point));
        }
    }

    private Point updatePoint(int index, int countOfPerson, Point currentPoint) {
        if (index == countOfPerson - 1) {
            return currentPoint.last();
        }
        if (index > 0) {
            return currentPoint.next(RANDOM.nextBoolean());
        }
        return currentPoint;
    }

    //todo
    public int move(int position) {
        return this.crosses.get(position).move();
    }

    //todo
    public int getCrossSize() {
        return crosses.size();
    }

    public String getLineForPrint(String trueSymbol, String falseSymbol) {
        return LINE_DELIMITER
                + crosses.stream()
                .map(cross -> cross.getCrossForPrint(trueSymbol, falseSymbol))
                .collect(Collectors.joining(LINE_DELIMITER));
    }

}
