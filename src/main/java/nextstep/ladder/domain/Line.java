package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<Boolean> points;

    public Line(int countOfPerson) {
        points = new ArrayList<>(4);
    }

    public int getPointsSize() {
        return 0;
    }

    public void createBridge(int i) {
    }

    public boolean move(int i) {
        return false;
    }
}
