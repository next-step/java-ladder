package nextstep.ladder.domain;

public class Junction {
    private Junction left;
    private Junction right;

    public boolean hasLeft() {
        return left != null;
    }

    public boolean hasRight() {
        return right != null;
    }

    public void connectRight(Junction right) {
        this.right = right;
        right.left = this;
    }

    public boolean hasConnect() {
        return this.hasLeft() || this.hasRight();
    }
}
