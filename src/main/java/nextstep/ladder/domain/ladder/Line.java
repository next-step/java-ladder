package nextstep.ladder.domain.ladder;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private Height height;
    private List<Boolean> points = new ArrayList<>();

    public Line(Height height, List<Boolean> points) {
        this.height = height;
        this.points = points;
    }

    public int getHeight() {
        return height.getHeight();
    }

    public List<Boolean> getPoints() {
        return points;
    }

    public boolean isValidateNextLine(Line nextLine) {
        for (int index = 0; index < points.size(); index++) {
            if (points.get(index) && !nextLine.getPoints().get(index)) {
                return false;
            }
        }
        return true;
    }
}
