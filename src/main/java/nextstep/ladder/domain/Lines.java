package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lines {
    private static final int FIRST_INDEX = 0;

    private List<Line> lines;

    public Lines(List<Line> lines) {
        this.lines = lines;
    }

    public static Lines drawLines(LadderInputs participants, DrawStrategy drawStrategy) {
        List<Line> lines = new ArrayList<>();
        boolean previous = false;

        for (int i = FIRST_INDEX; i < participants.countOfInputs(); i++) {
            boolean draw = drawStrategy.draw(i, previous);
            lines.add(new Line(draw));
            previous = draw;
        }

        return new Lines(lines);
    }

    public Results followLine(Results previousResults) {
        Map<Integer, Result> newResults = new HashMap<>();

        for (int i = 0; i < lines.size(); i++) {
            if (i + 1 < lines.size() && lines.get(i + 1).hasLine()) {
                newResults.put(previousResults.equalValueKey(i), previousResults.updateValue(i, 1));
            } else if (lines.get(i).hasLine()) {
                newResults.put(previousResults.equalValueKey(i), previousResults.updateValue(i, -1));
            } else {
                newResults.put(previousResults.equalValueKey(i), previousResults.updateValue(i , 0));
            }
        }

        return new Results(newResults);
    }

//    private void movePoint(Results previousResults, int index) {
//        int nextIndex = index + 1;
//        if (nextIndex < lines.size() && lines.get(nextIndex).hasLine()) {
//            previousResults.updateResult(index, 1);
//        }
//
//        if (lines.get(index).hasLine()) {
//            previousResults.updateResult(index, -1);
//        }
//    }

    public int numberOfLines() {
        return lines.size();
    }

    public List<Line> getLines() {
        return lines;
    }
}
