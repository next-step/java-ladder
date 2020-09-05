package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {

    private List<Boolean> points = new ArrayList<>();

    public Line(int countOfPerson) {
        int bridgeSize = betweenUserSize(countOfPerson);
        boolean isExistBridge = false;

        for (int i = 0; i < bridgeSize; i++) {
            isExistBridge = generateBridge(isExistBridge);
            points.add(isExistBridge);
        }
    }

    private int betweenUserSize(int userCount) {
        return userCount - 1;
    }

    private boolean generateBridge(boolean previous) {
        if (previous) {
            return false;
        }

        return new Random().nextBoolean();
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
