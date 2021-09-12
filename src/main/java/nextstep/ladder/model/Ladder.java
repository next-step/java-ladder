package nextstep.ladder.model;

public class Ladder {
    private final boolean[] hasSteps;

    public Ladder(int height) {
        this.hasSteps = new boolean[height];
    }

    public void drawSteps(DrawStrategy drawStrategy, Ladder previousLadder) {
        for (int height = 0; height < hasSteps.length; height++) {
            decideToDraw(drawStrategy, previousLadder, height);
        }
    }

    private void decideToDraw(DrawStrategy drawStrategy, Ladder previousLadder, int i) {
        if (drawStrategy.draw() && (previousLadder == null || !previousLadder.hasStep(i))) {
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
