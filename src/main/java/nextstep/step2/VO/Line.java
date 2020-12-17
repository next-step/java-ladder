package nextstep.step2.VO;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private List<Point> line = new ArrayList<>();

    public void addPoint(Point point) {
        line.add(point);
    }

    public Point getLastPoint() {
        return line.get(line.size()-1);
    }
}
