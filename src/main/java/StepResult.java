
public class StepResult {
    private boolean horizontalMovable;
    private Dot curDot;

    public StepResult(Dot curDot, boolean horizontalMovable) {
        this.curDot = curDot;
        this.horizontalMovable = horizontalMovable;
    }

    public StepResult refresh(Dot curDot, boolean horizontalMovable) {
        this.curDot = curDot;
        this.horizontalMovable = horizontalMovable;

        return this;
    }

    public boolean getHorizontalMovable() {
        return horizontalMovable;
    }

    public Dot getCurDot() {
        return curDot;
    }

    public int playerNumber() {
        return curDot.playerNumber();
    }

    public boolean lowerHeightThan(int height) {
        return this.curDot.getY() < height;
    }
}
