package nextstep.ladder.domain;

import nextstep.ladder.domain.exceptions.PointsNeedMoreThanOnePersonException;

import java.util.ArrayList;
import java.util.List;

public class LineFactory {
    private static final int MIN_COUNT_OF_PERSON = 1;

    public static Line create(int countOfPerson, PointAddStrategy pointAddStrategy) {
        validateCountOfPerson(countOfPerson);
        return new Line(new ArrayList<>(makeLine(countOfPerson, pointAddStrategy)));
    }

    private static List<Boolean> makeLine(int countOfPerson, PointAddStrategy pointAddStrategy) {
        List<Boolean> values = new ArrayList<>();
        values.add(false);

        if (countOfPerson == MIN_COUNT_OF_PERSON) {
            return values;
        }

        for (int i = 1; i < countOfPerson; i++) {
            values.add(pointAddStrategy.confirmPointLocation(!values.get(values.size() - 1)));
        }
        return values;
    }

    private static void validateCountOfPerson(int countOfPerson) {
        if (countOfPerson < MIN_COUNT_OF_PERSON) {
            throw new PointsNeedMoreThanOnePersonException("Need more than one people to make line");
        }
    }
}
