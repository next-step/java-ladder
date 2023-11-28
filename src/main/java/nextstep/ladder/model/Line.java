package nextstep.ladder.model;

import nextstep.ladder.model.strategy.DontDrawLine;
import nextstep.ladder.model.strategy.LineStrategy;
import nextstep.ladder.model.strategy.RandomLine;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<Boolean> points;

    public Line(List<Boolean> points) {
        this.points = points;
    }

    public Line generateLine() {
        List<Boolean> points = new ArrayList<>();
        for (int pointIndex = 0; pointIndex < this.points.size(); pointIndex++) {
            drawOrStop(points, pointIndex);
        }
        return new Line(points);
    }

    private void drawOrStop(List<Boolean> points, int pointIndex) {
        if (this.points.get(pointIndex)) {
            points.add(drawOrStop(new DontDrawLine()));
            return;
        }
        points.add(drawOrStop(new RandomLine()));
    }

    private boolean drawOrStop(LineStrategy lineStrategy) {
        return lineStrategy.drawLine();
    }

    public boolean point(int index){
        return this.points.get(index);
    }
    List<Boolean> points(){
        return this.points;
    }
}
