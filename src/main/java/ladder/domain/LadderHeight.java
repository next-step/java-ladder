package ladder.domain;


public class LadderHeight {

    public static final String LADDER_HEIGHT_IS_WRONG = "Ladder height is wrong.";
    private static final int MIN_HEIGHT = 0;
    private final int value;

    public LadderHeight(int value) {
        valid(value);
        this.value = value;
    }

    private void valid(int value) {
        if (value <= MIN_HEIGHT) {
            throw new IllegalArgumentException(LADDER_HEIGHT_IS_WRONG);
        }
    }

    public int size() {
        return value;
    }
}
