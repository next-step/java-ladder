package nextstep.ladder.domain.ladder;

import nextstep.ladder.application.CreatePointStrategy;
import nextstep.ladder.application.RandomCreatePoint;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ColumnLine {
    private List<Boolean> points = new ArrayList<>();

    public ColumnLine(Height height) {
        initPoints(height.getValue());
    }

    public ColumnLine(List<Boolean> points) {
        this.points = points;
    }

    private void initPoints(int height) {
        for (int i = 0; i < height; i++) {
            points.add(false);
        }
    }

    public Boolean getPointOfHeight(int heightIndex) {
        return points.get(heightIndex);
    }

    public void setDrownPosition(int heightIndex) {
        points.set(heightIndex,false);
    }

    public List<Boolean> getPoints() {
        return points;
    }

    public void draw(ColumnLine nextColumnLine) {
        for (int index = 0; index < this.points.size(); index++) {
            drawRowLine(nextColumnLine, index, RandomCreatePoint.of());
        }
    }

    public void drawRowLine(ColumnLine nextColumnLine, int index, CreatePointStrategy createPointStrategy) {
        if(!this.points.get(index) && createPointStrategy.isDraw()) {
            this.points.set(index, true);
            nextColumnLine.points.set(index,true);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ColumnLine that = (ColumnLine) o;
        return Objects.equals(points, that.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}
