package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lines {
    private static final int FIRST_INDEX = 0;
    private static final int RIGHT = 1;
    private static final int LEFT = -1;

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

        for (int i = FIRST_INDEX; i < lines.size(); i++) {
            UpdateResults(previousResults, newResults, i);
        }

        return new Results(newResults);
    }

    private void UpdateResults(Results previousResults, Map<Integer, Result> newResults, int index) {
        int nextIndex = index + RIGHT;
        if (hasNextLine(nextIndex)) {
            newResults.put(previousResults.equalValueKey(index), previousResults.updateValue(index, RIGHT));
            return;
        }

        if (hasCurrentLine(index)) {
            newResults.put(previousResults.equalValueKey(index), previousResults.updateValue(index, LEFT));
            return;
        }

        newResults.put(previousResults.equalValueKey(index), previousResults.updateValue(index, FIRST_INDEX));
    }

    private boolean hasNextLine(int nextIndex) {
        return nextIndex < lines.size() && lines.get(nextIndex).hasLine();
    }

    private boolean hasCurrentLine(int index) {
        return lines.get(index).hasLine();
    }

    public int numberOfLines() {
        return lines.size();
    }

    public List<Line> getLines() {
        return lines;
    }
}
