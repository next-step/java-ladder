package nextstep.ladder.domain;

public class Point {

    private final boolean left;
    private final boolean right;

    private static final String CREATE_POINT_EXCEPTION_MESSAGE = "연속으로 가로선이 겹칠 수 없습니다.";

    public Point(boolean left, boolean right) {
        validateDirection(left, right);

        this.left = left;
        this.right = right;
    }

    private void validateDirection(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalArgumentException(CREATE_POINT_EXCEPTION_MESSAGE);
        }
    }

    public static Point first(boolean isLine){
        return new Point(false, isLine);
    }

    public Point last(){
        return new Point(right, false);
    }

    public Point next(boolean isLine){
        if (right) {
            return new Point(true, false);
        }

        return new Point(false, isLine);
    }

    public boolean isLine(){
        return right;
    }

    public int move(){
        int result = 0;
        if (right) {
            return ++result;
        }

        if (left) {
            return --result;
        }

        return result;
    }
}
