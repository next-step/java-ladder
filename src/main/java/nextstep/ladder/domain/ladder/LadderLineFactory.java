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
        // TODO: 변경된 Point 생성자에 맞춰서 객체를 생성할 수 있도록 변경 필요
        List<Point> values = new ArrayList<>();
        values.add(new Point(false));

        if (countOfPerson == MIN_COUNT_OF_PERSON) {
            return values;
        }

        for (int i = 1; i < countOfPerson; i++) {
            values.add(new Point(
                    pointAddStrategy.confirmPointLocation(
                            !values.get(values.size() - 1).getValue())));
        }
        return values;
    }

    private static void validateCountOfPerson(int countOfPerson) {
        if (countOfPerson < MIN_COUNT_OF_PERSON) {
            throw new PointsNeedMoreThanOnePersonException("Need more than one people to make line");
        }
    }
}
