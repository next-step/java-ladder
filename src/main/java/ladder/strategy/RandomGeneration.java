package ladder.strategy;

import ladder.constant.Point;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomGeneration implements GenerationStrategy {
    
    private static final Random random = new Random();

    @Override
    public List<Point> generatePoints(int count) {
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            generateRandom(points);
        }
        return points;
    }

    private void generateRandom(List<Point> points) {
        if (isLastPointConnected(points)) {
            points.add(Point.DISCONNECTED);
            return;
        }
        points.add(Point.valueOf(random.nextBoolean()));
    }

    private boolean isLastPointConnected(List<Point> points) {
        if (points.isEmpty()) {
            return false;
        }
        return points.get(points.size() - 1).isConnect();
    }

}
