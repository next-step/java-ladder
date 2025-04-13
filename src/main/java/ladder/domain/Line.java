package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    private final List<Boolean> points;

    private Line(List<Boolean> points) {
        this.points = points;
    }

    public static Line generate(int width) {
        List<Boolean> points = new ArrayList<>();
        Random random = new Random();
        boolean prev = false;

        for (int i = 0; i < width; i++) {
            boolean connect = !prev && random.nextBoolean();
            points.add(connect);
            prev = connect;
        }

        return new Line(points);
    }

    public int width() {
        return points.size();
    }

    public boolean isConnected(int i) {
        return points.get(i);
    }
}
