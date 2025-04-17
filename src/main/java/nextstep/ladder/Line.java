package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Line {
    private final List<Boolean> points;

    public Line(int playerCount, Random random) {
        this.points = new ArrayList<>();

        for (int i = 0; i < playerCount; i++) {
            if (i == 0) {
                points.add(random.nextBoolean());
            } else if (points.get(i-1) == true) {
                points.add(false);
            } else {
                points.add(random.nextBoolean());
            }
        }
    }

    public List<Boolean> getPoints() {
        return points;
    }

    public int getFinalPosition(int startPosition) {
        int position = startPosition;
        for (int i = 0; i < points.size(); i++) {
            if (position == i && points.get(i)) {
                position++;
            } else if (position == i + 1 && points.get(i)) {
                position--;
            }
        }
        return position;
    }
}
