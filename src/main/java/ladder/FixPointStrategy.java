package ladder;

import java.util.List;

public class FixPointStrategy implements PointStrategy{

    private final List<Boolean> points;
    private int index = 0;

    public FixPointStrategy(List<Boolean> points) {
        this.points = points;
    }
    @Override
    public boolean generate() {
        if (index > points.size()) {
            return false;
        }
        return points.get(index++);
    }
}
