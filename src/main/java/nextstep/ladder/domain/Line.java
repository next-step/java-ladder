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

    public Points points() {
        return points;
    }

    public int move(int position) {
        if (canMoveLeft(position)) {
            return moveLeft(position);
        }
        if (canMoveRight(position)) {
            return moveRight(position);
        }
        return position;
    }

    private boolean canMoveLeft(int position) {
        return position > 0 && points.isConnected(position - 1);
    }

    private boolean canMoveRight(int position) {
        return position < points.size() && points.isConnected(position);
    }

    private int moveLeft(int position) {
        return position - 1;
    }

    private int moveRight(int position) {
        return position + 1;
    }
}
