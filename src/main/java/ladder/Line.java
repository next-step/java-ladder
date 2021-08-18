package ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    private List<Boolean> points = new ArrayList<>();

    public Line(int countOfPlayer) {
        boolean state = false;
        Random random = new Random();
        for (int i = 0; i < countOfPlayer - 1; i++) {
            if (state) {
                state = false;
            } else {
                state = random.nextBoolean();
            }
            this.points.add(state);
        }
    }

    public List<Boolean> getPoints() {
        return this.points;
    }
}
