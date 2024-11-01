package nextstep.ladder.domain;

public class Line {
    private final Points points;

    private Line(Points points) {
        this.points = points;
    }

    public static Line createLine(int participantsCount) {
        return new Line(Points.of(participantsCount - 1));
    }

    public void drawLine(int position) {
        if (canDrawLine(position)) {
            points.connect(position);
        }
    }

    private boolean canDrawLine(int position) {
        return !points.hasAdjacentConnection(position);
    }

    public boolean hasLine(int position) {
        return points.isConnected(position);
    }

    public int size() {
        return points.size();
    }
}
