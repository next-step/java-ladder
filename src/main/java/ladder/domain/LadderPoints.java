package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LadderPoints {
    private static final int SUBTRACT_NUMBER = 1;
    private static Random random = new Random();
    private List<LadderPoint> points = new ArrayList<>();

    public LadderPoints(final int countOfPerson) {
        initLineList(countOfPerson);
    }

    private void initLineList(final int countOfPerson) {
        points.add(new LadderPoint(false));

        for (int i = 1; i < countOfPerson - SUBTRACT_NUMBER; i++) {
            points.add(new LadderPoint(points.get(points.size() - 1).isLadderPoint()));
        }
    }

    public List<LadderPoint> getPoints() {
        return points;
    }
}
