package nextstep.ladder.domain.line;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {

    private final Random random = new Random();

    private List<Boolean> points = new ArrayList<>();

    public Line(int countOfPerson) {
        boolean before = false;
        for (int i = 0; i < countOfPerson - 1; i++) {
            before = addLineValue(before);
        }
    }

    private boolean addLineValue(boolean before) {
        if (before == false) {
            boolean currentState = random.nextBoolean();
            points.add(currentState);
            return currentState;
        }
        return points.add(false);
    }

    public List<Boolean> getPoints() {
        return points;
    }

    public int size() {
        return points.size();
    }
}
