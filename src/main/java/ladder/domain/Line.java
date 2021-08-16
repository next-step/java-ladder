package ladder.domain;

import ladder.utils.RandomBooleanGenerator;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private static final int REQUIRED_NUMBER_OF_PEOPLE = 2;

    private final List<Boolean> points = new ArrayList<>();

    private Line(int countOfPerson) {
        points.add(false);
        points.add(RandomBooleanGenerator.execute());

        fillLineWithPoints(countOfPerson);
    }

    private void fillLineWithPoints(int countOfPerson) {
        for (int i = REQUIRED_NUMBER_OF_PEOPLE; i < countOfPerson; i++) {
            Boolean current = RandomBooleanGenerator.execute();
            Boolean beforePoint = points.get(i - 1);
            points.add(compareAdjacentPoint(beforePoint, current));
        }
    }

    private Boolean compareAdjacentPoint(Boolean beforePoint, Boolean current) {
        if (beforePoint != current) {
            return current;
        }
        return !current;
    }

    public static Line of(int countOfPerson) {
        return new Line(countOfPerson);
    }

    public int getSize() {
        return points.size();
    }

    public boolean havePoints(int i) {
        return points.get(i);
    }
}
