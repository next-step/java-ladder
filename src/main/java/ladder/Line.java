package ladder;

import java.util.List;

public class Line {
    private List<Boolean> points;

    public Line(int lineLength, LineMaker lineMaker) {
        this.points = lineMaker.makeLines(lineLength);
        Boolean pre = false;
        for (Boolean cur : points){
            if (pre && cur){
                throw new IllegalArgumentException();
            }
            pre = cur;
        }
    }

    public List<Boolean> getPoints() {
        return points;
    }

    public int size() {
        return this.points.size();
    }
}
