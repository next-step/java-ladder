package ladder.model.ladder;

public class Stile {
    private Stile left;
    private Stile right;

    public Stile() {
        this.left = null;
        this.right = null;
    }

    public static void connect(Stile left, Stile right) {
        if (left.isLeftConnected() || right.isRightConnected()) {
            throw new IllegalStateException("One of the stiles is already connected to another stile");
        }

        left.right = right;
        right.left = left;
    }

    public boolean isLeftConnected() {
        return left != null;
    }

    public boolean isRightConnected() {
        return right != null;
    }
}
