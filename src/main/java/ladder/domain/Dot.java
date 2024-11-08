package ladder.domain;

public class Dot {
    private static final int ONE = 1;
    private static final int MINUS_ONE = -1;

    private final int index;
    private final boolean value;
    private final boolean leftDotValue;

    private Dot(int index, boolean value, boolean leftDotValue) {
        if (value && leftDotValue) {
            throw new RuntimeException("사다리는 연속으로 이어질 수 없습니다");
        }
        this.index = index;
        this.value = value;
        this.leftDotValue = leftDotValue;
    }

    public boolean getValue() {
        return value;
    }

    public int getMoveStep() {
        if (leftDotValue) {
            return this.index + MINUS_ONE;
        }
        if (value) {
            return this.index + ONE;
        }
        return this.index ;
    }

    public Dot nextDot() {
        return new Dot(index + 1, !value, value);
    }
    public static Dot firstDot(boolean dotValue) {
        return new Dot(0, dotValue, false);
    }
    public static Dot lastDot(int index , boolean leftDotValue) {
        return new Dot( index, false , leftDotValue);
    }
}
