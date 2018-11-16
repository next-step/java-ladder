package domain.ladder;

import java.util.List;

public class Line {

    private List<Boolean> points;

    public Line(List<Boolean> points) {
        this.points = points;
    }

    public List<Boolean> getPoints() {
        return points;
    }

    public boolean leftMove(int location) {
        return location <= 0 ? false : points.get(location-1);
    }

    public boolean rightMove(int location) {
        return location >= points.size() ? false : points.get(location);
    }

    public int Move(int location) {
        if(leftMove(location)) location--;
        if(rightMove(location)) location++;
        return location;
    }
}
