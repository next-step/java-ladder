package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private List<Boolean> points = new ArrayList<>();

    public Line(int countOfPerson, boolean hasLadder) { //참가자수
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
