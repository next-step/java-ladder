package nextstep.ladder.domain;

import java.util.List;

public class Line {
    private final List<Boolean> points;

    public Line(List<Boolean> points) {
        validate(points);
        this.points = points;
    }

    public List<Boolean> getPoints() {
        return this.points;
    }

    public int size() {
        return this.points.size();
    }

    public boolean hasLine(int i) {
        return points.get(i);
    }

    public int move(int index) {
        if(canMoveRight(index)) return index + 1;
        if (canMoveLeft(index)) return index - 1;
        return index;
    }

    private boolean canMoveLeft(int index) {
        return index > 0 && this.hasLine(index - 1);
    }

    private boolean canMoveRight(int index) {
        return index < this.getPoints().size() && this.hasLine(index);
    }

    private void validate(List<Boolean> points) {
        for (int i = 0; i < points.size() - 1; i++) {
            if (points.get(i) && points.get(i + 1)) {
                throw new IllegalArgumentException("가로선이 연속될 수 없습니다.");
            }
        }
    }
}
