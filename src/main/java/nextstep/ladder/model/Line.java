package nextstep.ladder.model;

import java.util.Collections;
import java.util.List;

public class Line {
    // points.get(N): N번째 세로줄과 N+1번째 세로줄 사이에 가로선이 존재하는가? (0번부터 시작)
    private final List<Boolean> movingPoints;

    public Line(List<Boolean> movingPoints) {
        this.movingPoints = movingPoints;
    }

    public int move(int position) {
        if (canMoveLeft(position)) {
            return position - 1;
        }
        if (canMoveRight(position)) {
            return position + 1;
        }
        return position;
    }

    public List<Boolean> getMovingPoints() {
        return Collections.unmodifiableList(movingPoints);
    }

    private boolean canMoveLeft(int position) {
        return position > 0 && movingPoints.get(position - 1);
    }

    private boolean canMoveRight(int position) {
        return position < movingPoints.size() && movingPoints.get(position);
    }
}
