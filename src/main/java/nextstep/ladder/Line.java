package nextstep.ladder;

public class Line {

    private final Points points;

    public Line(int count) {
         points = new Points(count);
    }

    @Override
    public String toString() {
        return points.toString();
    }
}
