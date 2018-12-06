package ladder.domain;

import java.util.Arrays;

import ladder.utils.DirectoryStrategy;
import ladder.utils.RandomUtils;

public enum Difficulty{

    HIGH       ("상", 20, () -> RandomUtils.generate(75)),
    MIDDLE     ("중", 10, () -> RandomUtils.generate(50)),
    LOW        ("하", 5, () -> RandomUtils.generate(25));

    private final String text;
    private final int height;
    private final DirectoryStrategy strategy;

    Difficulty(String text, int height, DirectoryStrategy strategy) {
        this.text = text;
        this.height = height;
        this.strategy = strategy;
    }

    public static Difficulty findByText(String text) {
        return Arrays.asList(Difficulty.values()).stream()
                .filter(difficulty -> difficulty.text.equals(text))
                .findAny()
                .orElse(Difficulty.MIDDLE);
    }

    public static Difficulty findByHeight(int height) {
        if(!isValidHeight(height)) {
            throw new IllegalArgumentException();
        }

        return Arrays.asList(Difficulty.values()).stream()
                .filter(difficulty -> difficulty.height == height)
                .findAny()
                .orElse(Difficulty.MIDDLE);
    }

    private static boolean isValidHeight(int height) {
        return 0 < height;
    }

    public int height() {
        return height;
    }

}
