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
        values.add(Point.first(pointAddStrategy));

        if (countOfPerson == MIN_COUNT_OF_PERSON) {
            return values;
        }

        for (int i = 1; i < countOfPerson - 1; i++) {
            values.add(values.get(values.size() - 1).next(pointAddStrategy));
        }

        values.add(values.get(values.size() - 1).last());

        return values;
    }

    private static void validateCountOfPerson(int countOfPerson) {
        if (countOfPerson < MIN_COUNT_OF_PERSON) {
            throw new PointsNeedMoreThanOnePersonException("Need more than one people to make line");
        }
    }
}
