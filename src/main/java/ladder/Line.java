package ladder;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private List<Boolean> points;

    public Line(int lineLength, PointMakert pointMakert) {
        this.points = this.makePoints(lineLength, pointMakert);
    }

    public List<Boolean> makePoints(int lineCount, PointMakert pointMaker) {
        List<Boolean> points = new ArrayList<>();
        boolean pre = false;
        boolean cur;
        for (int i = 0; i < lineCount; i++) {
            if (pre){
                points.add(false);
                pre = false;
                continue;
            }
            cur = pointMaker.nextBoolean();
            points.add(cur);
            pre = cur;
        }
        return points;
    }

    public List<Boolean> getPoints() {
        return points;
    }

    public int size() {
        return this.points.size();
    }
}
