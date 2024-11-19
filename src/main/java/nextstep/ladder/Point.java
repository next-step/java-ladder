package nextstep.ladder;

public class Point {
    private boolean left;
    private boolean right;

    public Point(boolean left, boolean right) {
        this.left = left;
        this.right = right;
    }

    public boolean getRight() {
        return right;
    }

    public String getLineSymbol(String trueSymbol, String falseSymbol) {
        return right ? trueSymbol : falseSymbol;
    }

    public int getResultIndex(int index) {
        return left ? index - 1 : (right ? index + 1 : index);
    }

    @Override
    public String toString() {
        return "Point{" +
                "left=" + left +
                ", right=" + right +
                '}';
    }
}
