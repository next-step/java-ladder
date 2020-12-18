package nextstep.laddergame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Line {
    private final List<Boolean> points = new ArrayList<>();
    private final MovingStrategy movingStrategy;

    public Line(int length) {
        this.movingStrategy = new RandomStrategy();
        IntStream.range(0, length)
                .forEach(index -> addPoint(index));
    }

    private void addPoint(int index) {
        if (isOdd(index)) {
            addRandomWay(index);
            return;
        }
        addPossibleWay();
    }

    private void addPossibleWay() {
        points.add(Boolean.TRUE);
    }

    private void addImpossibleWay() {
        points.add(Boolean.FALSE);
    }

    private void addRandomWay(int index) {
        if (isFirstPoint(index)) {
            setPoint(this.movingStrategy);
            return;
        }

        if (checkFrontWay(index)) {
            addImpossibleWay();
            return;
        }

        setPoint(this.movingStrategy);
    }

    private boolean checkFrontWay(int index) {
        return this.points.get(index - 2);
    }

    private void setPoint(MovingStrategy movingStrategy) {
        this.points.add(movingStrategy.isMovable());
    }

    private boolean isFirstPoint(int index) {
        return index - 1 == 0;
    }

    private boolean isOdd(int index) {
        return index % 2 == 1;
    }

    public boolean isWay(int point) {
        if (isNotLadderLine(point)) {
            throw new IndexOutOfBoundsException("사다리의 범위를 초과했습니다.");
        }

        return this.points.get(point);
    }

    private boolean isNotLadderLine(int point) {
        return this.points.size() < point;
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
