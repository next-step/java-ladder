package nextstep.ladder.domain.ladder;

import nextstep.ladder.application.RandomCreatePoint;

import java.util.ArrayList;
import java.util.List;

public class ColumnLine {
    private Height height;
    private List<Boolean> points = new ArrayList<>();

    public ColumnLine(Height height) {
        this.height = height;
        initPoints(height);
    }

    private void initPoints(Height height) {
        for (int i = 0; i < height.getHeight(); i++) {
            points.add(false);
        }
    }

    public ColumnLine(Height height, List<Boolean> points) {
        this.height = height;
        this.points = points;
    }

    public int getHeight() {
        return height.getHeight();
    }

    public ColumnLine draw(ColumnLine nextColumnLine) {
        for (int index = 0; index < this.points.size(); index++) {
            drawRowLine(nextColumnLine, index);
        }
        return this;
    }

    private void drawRowLine(ColumnLine nextColumnLine, int index) {
        if(!this.points.get(index) && RandomCreatePoint.of().isDraw()) {
            this.points.set(index, true);
            nextColumnLine.points.set(index,true);
        }
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
