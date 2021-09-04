package step2.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Line {
    private final List<Boolean> points;

    public Line(int numberOfUser, LadderStrategy ladderStrategy) {
        points = new ArrayList<>();

        for (int i = 0; i < numberOfUser; i++) {
            drawPoint(numberOfUser, ladderStrategy, i);
        }

    }

    public Line(List<Boolean> points) {
        this.points = points;
    }

    public List<Boolean> getLine() {
        return this.points;
    }

    private void drawPoint(int numberOfUser, LadderStrategy ladderStrategy, int index) {
        boolean isPoint = ladderStrategy.generateLine();

        if (isLast(numberOfUser, index) || !isFirst(index) && lastPoint()) {
            isPoint = false;
        }

        points.add(isPoint);
    }

    public int checkPoint(int index){
        if (points.get(index)) {
            return 1;
        }

        if(index!=0 && points.get(index-1)) {
            return -1;
        }

        return 0;
    }

    private boolean isLast(int numberOfUser, int index) {
        return index == numberOfUser - 1;
    }

    private boolean isFirst(int index) {
        return index == 0;
    }

    private boolean lastPoint() {
        return points.get(points.size() - 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(points, line.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}
