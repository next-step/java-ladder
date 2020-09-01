package ladder.domain;

public class Point {

    private boolean left;
    private boolean right;

    public boolean canMake() {
        return !this.left && !this.right;
    }

    public boolean hasLeft() {
        return this.left;
    }

    public boolean hasRight() {
        return this.right;
    }

    public void makeOnLeft() {
        this.left = true;
    }

    public void makeOnRight() {
        this.right = true;
    }
}
