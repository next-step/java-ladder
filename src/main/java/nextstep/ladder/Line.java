package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private List<Boolean> points = new ArrayList<>();

    public Line(int countOfPerson, boolean hasLadder) { //참가자수
        if (countOfPerson < 1) {
            throw new IllegalArgumentException("참가자는 1명 이상이어야 합니다.");
        }

        for (int i = 0; i < countOfPerson - 1; i++) {
            //hasLadder = random.nextBoolean();
            for (int j = 0; j < 5; j++) {
                points.add(hasLadder);
            }
        }
    }

    public List<Boolean> getPoints() {
        return points;
    }

}
