package ladder.domain.ladder;

public class PillarCount {

    static final int MIN_COUNT = 1;

    private final int value;

    private PillarCount(final int value) {
        verifyCount(value);
        this.value = value;
    }

    public static PillarCount of(final int value) {
        return new PillarCount(value);
    }

    private static void verifyCount(final int count) {
        if (count < MIN_COUNT) {
            throw new IllegalArgumentException("기둥의 개수는 최소 1 이상이여야 합니다.");
        }
    }
}
