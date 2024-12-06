
public class Step {
    private boolean horizontalMovable;
    private int curHeight;
    private Dot curDot;

    public Step(Dot curDot, int curHeight, boolean horizontalMovable) {
        this.curDot = curDot;
        this.curHeight = 0;
        this.horizontalMovable = horizontalMovable;
    }

    public Step refresh(Dot curDot, int curHeight, boolean horizontalMovable) {
        this.curDot = curDot;
        this.curHeight = curHeight;
        this.horizontalMovable = horizontalMovable;

        return this;
    }

    public int height() {
        return this.curHeight;
    }

    public int resultNumber() {
        return curDot.playerNumber();
    }

    public boolean lowerHeightThan(int height) {
        return this.curDot.yIsLowerThan(height);
    }

    public Step forward(Line line) {
        if (availLeft(line) && this.horizontalMovable) {
            return this.refresh(curDot.moveLeft(), this.curHeight, false);
        }

        if (availRight(line) && this.horizontalMovable) {
            return this.refresh(curDot.moveRight(), this.curHeight, false);
        }

        return this.refresh(curDot.moveDown(), this.curHeight + 1, true);
    }

    private boolean availRight(Line line) {
        if (curDot.xIs(line.size() - 1)) {
            return false;
        }

        return line.isBridge(curDot.calcAddX(1));
    }

    private boolean availLeft(Line line) {
        if (curDot.xIs(0)) {
            return false;
        }

        return line.isBridge(curDot.calcAddX(-1));
    }
}
