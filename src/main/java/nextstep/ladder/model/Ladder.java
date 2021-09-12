package nextstep.ladder.model;

public class Ladder {
    private final boolean[] hasSteps;

    public Ladder(int height) {
        this.hasSteps = new boolean[height];
    }

    public void drawSteps(DrawStrategy drawStrategy, Ladder previousLadder) {
        for (int i = 0; i < hasSteps.length; i++) {
            if (drawStrategy.draw() && (previousLadder == null || !previousLadder.hasStep(i))) {
                this.hasSteps[i] = true;
            }
        }
    }

    public boolean hasStep(int height) {
        return hasSteps[height];
    }

    public int height() {
        return hasSteps.length;
    }
}
