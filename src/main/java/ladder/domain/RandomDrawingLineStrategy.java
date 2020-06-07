package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class RandomDrawingLineStrategy implements DrawingLineStrategy {
    
    @Override
    public List<Point> drawLine(int playerCounts) {
        List<Point> points = new ArrayList<>();

        for (int i = 0; i < playerCounts - 1; i++) {
            points.add(new Point(true));
        }
        return points;
    }
}
