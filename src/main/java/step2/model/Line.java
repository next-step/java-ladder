package step2.model;

import step2.strategy.DrawStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Line {
    private List<Boolean> rungs = new ArrayList<>();

    public void drawNewLine(int countOfPerson, DrawStrategy strategy) {
        rungs = Stream
                .generate(() -> draw(strategy))
                .limit(countOfPerson - 1)
                .collect(Collectors.toList());
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
}
