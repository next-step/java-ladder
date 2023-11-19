package ladder.domain;

import ladder.exception.LineDuplicateException;
import ladder.factory.PointFactory;

import java.util.List;

public class Line {

    private final List<Boolean> points;

    public Line(int countOfPerson,  PointFactory factory) {
        this.points = factory.points(countOfPerson - 1);
        validate();
    }

    private void validate() {
        for (int i = 0; i < points.size() - 1; i++) {
            validateDuplicate(i);
        }
    }

    private void validateDuplicate(int index) {
        Boolean point1 = points.get(index);
        Boolean point2 = points.get(index + 1);

        if (point1 && point2) {
            throw new LineDuplicateException();
        }
    }

    public List<Boolean> points() {
        return this.points;
    }

}
