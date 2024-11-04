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
}
