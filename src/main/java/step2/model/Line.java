package step2.model;

import step2.strategy.DrawStrategy;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private List<Boolean> rungs = new ArrayList<>();

    public void drawNewLine(int countOfPerson, DrawStrategy strategy) {
        for (int loop = 0; loop < countOfPerson - 1; loop++) {
            rungs.add(draw(strategy));
        }
    }

    public boolean draw(DrawStrategy strategy) {
        boolean drawResult = strategy.draw();
        if (isEmptyAndDrawn(drawResult) || isRungFalseAndDrawnNow(drawResult)) {
            return true;
        }
        return false;
    }

    private boolean isEmptyAndDrawn(boolean drawnResult) {
        return rungs.isEmpty() && drawnResult;
    }

    private boolean isRungFalseAndDrawnNow(boolean drawnResult) {
        return isRungsNotEmpty() && isLastRungFalse() && drawnResult;
    }

    private boolean isLastRungFalse() {
        return !rungs.get(rungs.size() - 1);
    }

    private boolean isRungsNotEmpty() {
        return rungs.size() > 0;
    }

    public String printRungs() {
        return rungs.toString();
    }

    public List<Boolean> getRungs() {
        return rungs;
    }
}
