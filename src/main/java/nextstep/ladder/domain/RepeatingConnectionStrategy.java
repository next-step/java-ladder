package nextstep.ladder.domain;

public class RepeatingConnectionStrategy implements ConnectionStrategy {
    private static final boolean[] DEFAULT_PATTERN = {true, false};

    private final boolean[] pattern;
    private int index = 0;

    public RepeatingConnectionStrategy(boolean... pattern) {
        if (pattern.length == 0) {
            this.pattern = DEFAULT_PATTERN;
            return;
        }
        this.pattern = pattern;
    }

    @Override
    public boolean connect() {
        boolean value = pattern[index];
        index = (index + 1) % pattern.length;  // 반복 순환
        return value;
    }
}
