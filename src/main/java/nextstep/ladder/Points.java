package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;

public class Points {

    private final List<Boolean> points = new ArrayList<>();

    public Points(int countOfPerson, boolean hasLadder) {
        for (int i = 0; i < countOfPerson - 1; i++) {
            if (i >= 1 && hasLadder) {
                hasLadder = false;
                for (int j = 0; j < 5; j++) {
                    points.add(hasLadder);
                }
            } else {
                for (int j = 0; j < 5; j++) {
                    points.add(hasLadder);
                }
            }
        }
    }

    public void add(Boolean point) {
        points.add(point);
    }

    public int size() {
        return points.size();
    }

    public List<Boolean> getPoints() {
        return points;
    }

}
