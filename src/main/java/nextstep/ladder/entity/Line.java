package nextstep.ladder.entity;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<Boolean> point;

    public Line(int countOfPerson, int height) {
        this.point = initPoint(countOfPerson, height);
    }

    public boolean getPointIndex(int index){
        return point.get(index);
    }

    private List<Boolean> initPoint(int countOfPerson, int height) {
        List<Boolean> initPoint = new ArrayList<>();
        boolean point = countOfPerson % 2 == 0;

        initPoint.add(point);

        for (int i = 1; i < height; i++) {
            point = !point;
            initPoint.add(point);
        }

        return initPoint;
    }
}
