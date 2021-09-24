package nextstep.ladder.model;

import java.util.List;

public class Line {
    private final List<Step> steps;

    public Line(int height) {
        this.steps = Step.initialize(height);
    }

    public void drawSteps(DrawStrategy drawStrategy, Line previousLine) {
        for (int height = 0; height < steps.size(); height++) {
            decideToDraw(drawStrategy, previousLine, height);
        }
    }

    private void decideToDraw(DrawStrategy drawStrategy, Line previousLine, int height) {
        if (drawStrategy.draw() && (previousLine == null || !previousLine.hasStep(height))) {
            steps.set(height, Step.EXIST);
        }
    }

    public boolean hasStep(int height) {
        return steps.get(height).exist();
    }

    public int goLeftIfCan(int currentWidth, int currentHeight) {
        if (hasStep(currentHeight)) {
            return currentWidth - 1;
        }
        return currentWidth;
    }

    public int goRightIfCan(int currentWidth, int currentHeight) {
        if (hasStep(currentHeight)) {
            return currentWidth + 1;
        }
        return currentWidth;
    }

    public int height() {
        return steps.size();
    }
}
