package ladder.strategy;

import ladder.utils.RandomUtils;

import java.util.Arrays;

public enum  Difficulty {
    HIGH("상", 7, () -> RandomUtils.generate(75)),
    MIDDLE("중", 5, () -> RandomUtils.generate(50)),
    LOW("하", 3, () -> RandomUtils.generate(25));

    private final String text;
    private final int height;
    private final DifficultyStrategy strategy;

    Difficulty(String text, int height, DifficultyStrategy strategy) {
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

    public boolean generate() {
        return strategy.generate();
    }

    interface DifficultyStrategy {
        boolean generate();
    }
}
