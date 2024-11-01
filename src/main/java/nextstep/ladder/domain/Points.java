package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Points {

    private final List<Point> points;

    private Points(int size) {
        this.points = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            points.add(Point.create());
        }
    }

    public static Points of(int size) {
        return new Points(size);
    }

    public void connect(int position) {
        validatePosition(position);
        points.get(position).connect();
    }

    public boolean isConnected(int position) {
        validatePosition(position);
        return points.get(position).isConnected();
    }

    public boolean hasAdjacentConnection(int position) {
        return hasLeftConnection(position) || hasRightConnection(position);
    }

    private boolean hasLeftConnection(int position) {
        return position > 0 && isConnected(position - 1);
    }

    private boolean hasRightConnection(int position) {
        return position < points.size() - 1 && isConnected(position + 1);
    }

    private void validatePosition(int position) {
        if (position < 0 || position >= points.size()) {
            throw new IllegalArgumentException("유효하지 않은 위치입니다.");
        }
    }

    public int size() {
        return points.size();
    }
}
