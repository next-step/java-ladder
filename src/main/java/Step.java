
public class Step {
    private boolean horizontalMovable;
    private Dot curDot;

    public Step(Dot curDot, boolean horizontalMovable) {
        this.curDot = curDot;
        this.horizontalMovable = horizontalMovable;
    }

    public Step refresh(Dot curDot, boolean horizontalMovable) {
        this.curDot = curDot;
        this.horizontalMovable = horizontalMovable;

        return this;
    }

    public int getDotY() {
        return this.curDot.calcAddY(0);
    }

    public int playerNumber() {
        return curDot.playerNumber();
    }

    public boolean lowerHeightThan(int height) {
        return this.curDot.yIsLowerThan(height);
    }

    public Step forward(Line line) {
        if (availLeft(line) && this.horizontalMovable) {
            return this.refresh(curDot.moveLeft(), false);
        }

        if (availRight(line) && this.horizontalMovable) {
            return this.refresh(curDot.moveRight(), false);
        }

        return this.refresh(curDot.moveDown(), true);
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
