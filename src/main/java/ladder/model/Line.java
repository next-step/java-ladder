package ladder.model;

import java.util.List;

public class Line {
    private final List<Boolean> points;

    public Line(List<Boolean> points) {
        this.points = points;
    }

    public int getSizeOfLine() {
        return points.size();
    }

    public boolean isConnectedLadder(int index) {
        return points.get(index);
    }
}
