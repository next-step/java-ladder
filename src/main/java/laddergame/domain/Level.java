package laddergame.domain;

import laddergame.service.LadderValueGenerator;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

public enum Level implements LadderValueGenerator {

    EASY("하", 5, 2),
    MEDIUM("중", 10, 5),
    HARD("상", 20, 8);

    private String key;
    private int maximumHeight;
    private int chance;

    private static final Map<String, Level> levels = getLevels();
    private static final Random random = new Random();
    private static final int BOUND = 10;

    private static Map<String, Level> getLevels() {
        return Arrays.stream(values())
                .collect(Collectors.toMap(level -> level.getKey(), level -> level));
    }

    Level(String key, int maximumHeight, int chance) {
        this.key = key;
        this.maximumHeight = maximumHeight;
        this.chance = chance;
    }

    private String getKey() {
        return key;
    }

    public static Level getLevel(String key) {
        return Optional.ofNullable(levels.get(key))
                .orElseThrow(IllegalArgumentException::new);
    }

    public int getMaximumHeight() {
        return maximumHeight;
    }

    @Override
    public Boolean generate() {
        return random.nextInt(BOUND) <= chance;
    }
}