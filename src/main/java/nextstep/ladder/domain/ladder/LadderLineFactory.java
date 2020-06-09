package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.exceptions.PointsNeedMoreThanOnePersonException;

import java.util.ArrayList;
import java.util.List;

public class LadderLineFactory {
    private static final int MIN_COUNT_OF_PERSON = 1;

    public static LadderLine create(int countOfPerson, PointAddStrategy pointAddStrategy) {
        validateCountOfPerson(countOfPerson);
        return new LadderLine(new ArrayList<>(makeLine(countOfPerson, pointAddStrategy)));
    }

    private static List<Point> makeLine(int countOfPerson, PointAddStrategy pointAddStrategy) {
        List<Point> values = new ArrayList<>();
        values.add(new Point(0,
                new Direction(false, pointAddStrategy.confirmPointLocation(true))));

        if (countOfPerson == MIN_COUNT_OF_PERSON) {
            return values;
        }

        for (int i = 1; i < countOfPerson; i++) {
            // TODO: Point 객체 기능 구현 완료 후 다시 돌아올 것
            values.add(new Point(i, new Direction(
                    pointAddStrategy.confirmPointLocation(!values.get(values.size() - 1).getCurrentStatus()),
                    pointAddStrategy.confirmPointLocation(!values.get(values.size() - 1).getCurrentStatus())
            )));
        }
        return values;
    }

    private static void validateCountOfPerson(int countOfPerson) {
        if (countOfPerson < MIN_COUNT_OF_PERSON) {
            throw new PointsNeedMoreThanOnePersonException("Need more than one people to make line");
        }
    }
}
