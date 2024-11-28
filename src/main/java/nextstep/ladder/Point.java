package nextstep.ladder;

public class Point {
    private boolean current;
    private boolean right;

    public Point(boolean current, boolean right) {
        if(current && right) {
            throw new IllegalArgumentException("유효하지 않은 값입니다.");
        }
        this.current = current;
        this.right = right;
    }

    public boolean getRight() {
        return right;
    }

    public String getLineSymbol(String trueSymbol, String falseSymbol) {
        return right ? trueSymbol : falseSymbol;
    }

    public int getResultIndex(int index) {
        return current ? index - 1 : (right ? index + 1 : index);
    }

    @Override
    public String toString() {
        return "Point{" +
                "left=" + current +
                ", right=" + right +
                '}';
    }

    public Direction move() {
        if (current) {
            return Direction.LEFT;
        }
        if (right) {
            return Direction.RIGHT;
        }

        return Direction.DOWN;
    }
}
