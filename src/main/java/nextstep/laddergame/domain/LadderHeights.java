package nextstep.laddergame.domain;

public class LadderHeights {

    private static final int MINIMUM_HEIGHTS = 1;
    private static final String INVALID_HEIGHTS_EXCEPTION_MESSAGE_FORMAT = "사다리의 높이가 유효하지 않습니다. heights: %s";

    private final int heights;

    public LadderHeights(int heights) {
        validateMinimumHeights(heights);
        this.heights = heights;
    }

    private void validateMinimumHeights(int heights) {
        if (heights < MINIMUM_HEIGHTS) {
            throw new IllegalArgumentException(String.format(INVALID_HEIGHTS_EXCEPTION_MESSAGE_FORMAT, heights));
        }
    }

    public static LadderHeights of(int heights) {
        return new LadderHeights(heights);
    }

    public int getHeights() {
        return heights;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LadderHeights)) return false;
        LadderHeights that = (LadderHeights) o;
        return heights == that.heights;
    }

    @Override
    public int hashCode() {
        return heights;
    }
}
