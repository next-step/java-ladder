package nextstep.ladder.domain.member.position;

import nextstep.ladder.domain.line.point.Points;
import nextstep.ladder.domain.runresult.RunResult;
import nextstep.ladder.exceptions.CannotNullOrEmptyException;

import java.util.List;
import java.util.Objects;

public class PositionX {
    private int x;

    public PositionX(int x) {
        this.x = x;
    }

    public void increaseOrDecrease(Points points) {
        if (this.x == Position.DEFAULT_POSITION) {
            increaseOrStay(points);
            return;
        }

        if (points.sameSize(x)) {
            decreaseOrStay(points);
            return;
        }

        if (points.leftMatch(x)) {
            decrease();
            return;
        }

        if (points.rightMatch(x)) {
            increase();
        }
    }

    private void decreaseOrStay(Points points) {
        if (points.lastMatch()) {
            decrease();
        }
    }

    private void increaseOrStay(Points points) {
        if (points.firstMatch()) {
            increase();
        }
    }

    private synchronized void decrease() {
        this.x--;
    }

    private synchronized void increase() {
        this.x++;
    }

    public RunResult getFrom(List<RunResult> runResults) {
        validateNullOrEmpty(runResults);
        validateSize(runResults);

        return runResults.get(this.x);
    }

    private void validateSize(List<RunResult> runResults) {
        if (this.x > runResults.size()) {
            throw new IllegalArgumentException("길이가 부족합니다.");
        }
    }

    private void validateNullOrEmpty(List<RunResult> runResults) {
        if (runResults == null || runResults.isEmpty()) {
            throw new CannotNullOrEmptyException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PositionX positionX = (PositionX) o;
        return x == positionX.x;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x);
    }
}
