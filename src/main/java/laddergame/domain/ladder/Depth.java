package laddergame.domain.ladder;

public class Depth {

    private final int count;

    private static final int MIN_DEPTH = 1;

    private Depth(final int count) {
        validateDepth(count);
        this.count = count;
    }

    public static Depth of(int count) {
        return new Depth(count);
    }

    public int size() {
        return count;
    }

    private void validateDepth(final int depth) {
        if (depth < MIN_DEPTH) {
            throw new IllegalArgumentException("사다리의 깊이는 1이상이어야 합니다.");
        }
    }
}
