package nextstep.ladder.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Line {
    private static final int START_POINT = 0;
    private static final int ONCE_POINT = 1;
    private static final int REMOVE_FINAL_LINE = 1;

    private static final RandomBranchCreator randomBranchCreator = new RandomBranchCreator();

    private List<Boolean> points = new ArrayList<>();

    public Line(int countOfPerson) {
        makeLine(countOfPerson);
    }

    public Line(List<Boolean> points) {
        this.points = points;
    }

    private void makeLine(int countOfPerson) {
        IntStream.range(0, countOfPerson - REMOVE_FINAL_LINE)
                .forEach(point -> points.add(createPoint(point)));
    }

    private boolean createPoint(int point) {
        return !isExistBefore(point) && randomBranchCreator.createBranch();
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
