package nextstep.ladder.model;

public class Line {
    private final boolean[] hasSteps;

    public Line(int height) {
        this.hasSteps = new boolean[height];
    }

    public void drawSteps(DrawStrategy drawStrategy, Line previousLine) {
        for (int height = 0; height < hasSteps.length; height++) {
            decideToDraw(drawStrategy, previousLine, height);
        }
    }

    private void decideToDraw(DrawStrategy drawStrategy, Line previousLine, int i) {
        if (drawStrategy.draw() && (previousLine == null || !previousLine.hasStep(i))) {
            this.hasSteps[i] = true;
        }
    }

    public boolean hasStep(int height) {
        return hasSteps[height];
    }

    public int height() {
        return hasSteps.length;
    }
}
