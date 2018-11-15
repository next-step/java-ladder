package domain.ladder;

import java.util.ArrayList;

public class Line {

    ArrayList<Boolean> points;

    public Line(ArrayList<Boolean> points) {
        this.points = points;
    }

    public ArrayList<Boolean> getPoints() {
        return points;
    }
}
