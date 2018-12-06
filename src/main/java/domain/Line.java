package domain;

public class Line {

    private final Points points;

    public Line(final Points points) {
        this.points = points;
    }

    public static Line from(final int sizeOPlayers) {
        return new Line(Points.from(sizeOPlayers));
    }

    public int move(final int position) {
        return points.move(position);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(points.toString());
        return sb.toString();
    }

}
