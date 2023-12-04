package ladder2.domain;


import java.util.List;

public class Row {

    private final List<Point> points;

    private Row(List<Point> points) {
        this.points = points;
    }

    public static Row from(List<Point> points) {
        return new Row(points);
    }

    public void move(Player player) {
        Point point = points.get(player.position());


        if (point.move() == Direction.LEFT) {
            player.moveLeft();
        }

        if (point.move() == Direction.RIGHT) {
            player.moveRight();
        }
    }

    public int size() {
        return points.size();
    }

    @Override
    public String toString() {
        return points.toString();
    }
}
