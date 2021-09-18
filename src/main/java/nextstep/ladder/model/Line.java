package nextstep.ladder.model;

public class Line {
    private final Step[] steps;

    public Line(int height) {
        this.steps = Step.initialize(height);
    }

    public void drawSteps(DrawStrategy drawStrategy, Line previousLine) {
        for (int height = 0; height < steps.length; height++) {
            decideToDraw(drawStrategy, previousLine, height);
        }
    }

    private void decideToDraw(DrawStrategy drawStrategy, Line previousLine, int height) {
        if (drawStrategy.draw() && (previousLine == null || !previousLine.hasStep(height))) {
            this.steps[height] = Step.EXIST;
        }
    }

    public boolean hasStep(int height) {
        return steps[height].exist();
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
        return steps.length;
    }
}
