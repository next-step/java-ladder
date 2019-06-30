package nextstep.ladder.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Line {
    private final int START_POINT = 0;
    private final int ONCE_POINT = 1;

    private final List<Boolean> points = new ArrayList<>();

    Line(int countOfPerson) {
        makeLine(countOfPerson);
    }

    private void makeLine(int countOfPerson) {
        IntStream.range(0, countOfPerson - 1)
                .forEach(point -> points.add(createPoint(point)));
    }

    private boolean createPoint(int point) {
        if (isExistBefore(point) == false) {
            return BranchCreator.createBranchRandomly();
        }
        return false;
    }

    private boolean isExistBefore(int point) {
        if (START_POINT < point) {
            return points.get(point - ONCE_POINT);
        }
        return false;
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
