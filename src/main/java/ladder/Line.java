package ladder;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private List<Boolean> points;

    public Line(int lineLength, LineMaker lineMaker) {
        this.points = this.makeLines(lineLength, lineMaker);
    }

    public List<Boolean> makeLines(int lineCount, LineMaker lineMaker) {
        List<Boolean> lines = new ArrayList<>();
        boolean pre = false;
        boolean cur;
        for (int i = 0; i < lineCount; i++) {
            if (pre){
                lines.add(false);
                pre = false;
                continue;
            }
            cur = lineMaker.nextBoolean();
            lines.add(cur);
            pre = cur;
        }
        return lines;
    }

    public List<Boolean> getPoints() {
        return points;
    }

    public int size() {
        return this.points.size();
    }
}
