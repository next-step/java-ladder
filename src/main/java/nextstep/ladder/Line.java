package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private final Points points;

    public Line(int countOfPerson) {
        if (countOfPerson < 1) {
            throw new IllegalArgumentException("참가자는 1명 이상이어야 합니다.");
        }

        points = new Points(countOfPerson, new LadderGenerateStrategy());
    }

    public int size() {
        return points.size();
    }

    public List<Boolean> getPoints() {
        return points.getPoints();
    }

}
