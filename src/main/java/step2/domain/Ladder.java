package step2.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private List<Line> lines = new ArrayList<>();

    public Ladder(int height, boolean isStepable) {
        for (int i = 0; i < height; i++) {
            lines.add(new Line(isStepable));
        }
    }

    public Ladder(int height, boolean isStepable, Ladder beforeLadder) {
        for (int i = 0; i < height; i++) {
            lines.add(new Line(isStepable && !beforeLadder.getLines().get(i).isCanStepable()));
        }
    }

    public List<Line> getLines() {
        return lines;
    }

    public int getLineCount() {
        return lines.size();
    }


}
