package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LadderPoint {
    private static final int SUBTRACT_NUMBER = 1;
    private static Random random = new Random();
    private List<Boolean> points = new ArrayList<>();

    public LadderPoint(int countOfPerson) {
        initLineList(countOfPerson);
    }

    private void initLineList(final int countOfPerson) {
        for (int i = 0; i < countOfPerson - SUBTRACT_NUMBER; i++) {
            addPoint();
        }
    }

    private void addPoint() {
        if (points.size() == 0) {
            points.add(random.nextBoolean());

            return;
        }

        checkContinuityPoint();
    }

    private void checkContinuityPoint() {
        //연속으로 true가 나올경우
        if (this.points.get(points.size() - 1) == true) {
            this.points.add(false);

            return;
        }

        points.add(random.nextBoolean());
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
