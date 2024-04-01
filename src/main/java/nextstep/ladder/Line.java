package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private List<Boolean> points = new ArrayList<>();

    public Line(int countOfPerson) { //참가자수
        for (int i = 0; i < countOfPerson - 1; i++) {
            for (int j = 0; j < 5; j++) {
                points.add(true);
            }
        }
    }

    public List<Boolean> getPoints() {
        return points;
    }

}
