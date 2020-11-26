package domain;

public class Line {
    private Points points = new Points();

    public Line(int width) {
        for(int i = 0; i < width - 1; i++) {
            points.initialize(i);
        }
    }

    public Points getPoints() {
        return points;
    }
}
