package ladder.domain;

import java.util.Optional;

public class LadderHeight {
    public static final int MIN_HEIGHT = 1;
    private final int height;

    public LadderHeight(int arg) {
        Optional<Integer> height = Optional.of(arg);
        height.stream()
                .filter(num -> num >= MIN_HEIGHT)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("height must be bigger than 0"));
        this.height = arg;
    }

    public int getHeight() {
        return height;
    }
}
