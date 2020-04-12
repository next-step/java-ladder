package ladder.nextstep;

import ladder.engine.Line;

import java.util.List;

class NextStepLine implements Line {
    private final List<Point> points;

    NextStepLine(List<Point> points) {
        this.points = points;
    }

    @Override
    public int move(int position) {
        return points.get(position).move();
    }

    @Override
    public String toString() {
        return "NextStepLine{" +
                "points=" + points +
                '}';
    }
}

