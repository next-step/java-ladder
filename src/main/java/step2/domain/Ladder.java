package step2.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private List<Line> lineList = new ArrayList<>();

    public Ladder(int height, boolean isStepable) {
        for (int i = 0; i < height; i++) {
            lineList.add(new Line(isStepable));
        }
    }

    public Ladder(int height, boolean isStepable, Ladder beforeLadder) {
        for (int i = 0; i < height; i++) {
            lineList.add(new Line(isStepable && !beforeLadder.getLineList().get(i).isStep()));
        }
    }

    public List<Line> getLineList() {
        return lineList;
    }

    public int getLineCount() {
        return lineList.size();
    }


}
