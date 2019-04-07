package domain.ladder;

import util.BridgeGenerator;

public class Pair {
    private boolean left;
    private boolean right;

    public Pair() {
    }

    public Pair(boolean left, boolean right) {
        this.left = left;
        this.right = right;
    }

    public Pair make(boolean left) {
        this.left = left;
        this.right = generateBridge(left);
        return this;
    }

    private boolean generateBridge(boolean isLeft) {
        if (isLeft) {
            return false;
        }
        return BridgeGenerator.generate();
    }

    public boolean isLeft() {
        return left;
    }

    public boolean isRight() {
        return right;
    }
}
