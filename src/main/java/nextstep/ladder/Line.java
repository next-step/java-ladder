package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private final Points points;

    public Line(int countOfPerson, boolean hasLadder) {
        if (countOfPerson < 1) {
            throw new IllegalArgumentException("참가자는 1명 이상이어야 합니다.");
        }

        points = new Points(new ArrayList<>());

        for (int i = 0; i < countOfPerson - 1; i++) {
            if (i >= 1 && hasLadder) {
                hasLadder = false;
                for (int j = 0; j < 5; j++) {
                    points.add(hasLadder);
                }
            }

            for (int j = 0; j < 5; j++) {
                points.add(hasLadder);
            }
        }
    }

    public int size() {
        return points.size();
    }

    public List<Boolean> getPoints() {
        return points.getPoints();
    }

}
