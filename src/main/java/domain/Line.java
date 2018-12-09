package domain;

import util.DirectionGenerator;

public class Line {

    private final Points points;

    public Line(final Points points) {
        this.points = points;
    }

    public static Line from(final int sizeOPlayers, final DirectionGenerator generator) {
        return new Line(Points.from(sizeOPlayers, generator));
    }

    public int move(final int position) {
        return points.move(position);
    }

    @Override
    public String toString() {
        return points.toString();
    }

}
