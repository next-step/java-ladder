package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {

    private List<Point> pointList = new ArrayList<>();

    private final Random random = new Random();

    public Line(int countOfPerson) {
        if(countOfPerson <= 0){
            throw new IllegalArgumentException("참가자는 한명 이상이여야 합니다.");
        }
        for (int i = 0; i < countOfPerson; i++) {
            pointList.add(nextPoint(i));
        }
    }

    private Point nextPoint(int index) {
        if (index == 0) {
            return Point.emptyPoint();
        }
        Point previousPoint = pointList.get(index - 1);
        if (previousPoint.isFilled()) {
            return Point.emptyPoint();
        }
        return new Point(random.nextBoolean());
    }

    public List<Point> getPointList() {
        return pointList;
    }

    public int pointListSize() {
        return pointList.size();
    }

    public boolean isFilledAt(int index) {
        return pointList.get(index).isFilled();
    }
}
