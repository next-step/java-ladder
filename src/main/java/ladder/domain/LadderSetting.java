package ladder.domain;

public class LadderSetting {
    private final int stepCount;
    private final int lineCount;

    public LadderSetting(int stepCount, int lineCount) {
        this.stepCount = stepCount;
        this.lineCount = lineCount;
    }

    public int getStepCount() {
        return stepCount;
    }

    public int getLineCount() {
        return lineCount;
    }

}
