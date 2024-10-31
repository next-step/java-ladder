package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<Boolean> points;

    private Line(List<Boolean> points) {
        this.points = points;
    }

    public static Line createLine(int participantsCount) {
        List<Boolean> newPoints = new ArrayList<>();
        for (int i = 0; i < participantsCount - 1; i++) {
            newPoints.add(false);
        }
        return new Line(newPoints);
    }

    public void drawLine(int position) {
        validatePosition(position);
        if (canDrawLine(position)) {
            points.set(position, true);
        }
    }


    private boolean canDrawLine(int position) {
        if (position > 0 && points.get(position - 1)) {
            return false;
        }
        if (position < points.size() - 1 && points.get(position + 1)) {
            return false;
        }
        return true;
    }

    private void validatePosition(int position) {
        if (position < 0 || position >= points.size()) {
            throw new IllegalArgumentException("유효하지 않은 위치입니다.");
        }
    }

    public boolean hasLine(int position) {
        return points.get(position);
    }

    public int size() {
        return points.size();
    }
}
