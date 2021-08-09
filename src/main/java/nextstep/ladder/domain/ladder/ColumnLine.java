package nextstep.ladder.domain.ladder;

import nextstep.ladder.application.RandomCreatePoint;

import java.util.ArrayList;
import java.util.List;

public class ColumnLine {
    private List<Boolean> points = new ArrayList<>();

    public ColumnLine(Height height) {
        initPoints(height.getHeight());
    }

    private void initPoints(int height) {
        for (int i = 0; i < height; i++) {
            points.add(false);
        }
    }

    public ColumnLine(List<Boolean> points) {
        this.points = points;
    }

    public void draw(ColumnLine nextColumnLine) {
        for (int index = 0; index < this.points.size(); index++) {
            drawRowLine(nextColumnLine, index);
        }
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

    public void setDrownPosition(int heightIndex) {
        points.set(heightIndex,false);
    }
}
