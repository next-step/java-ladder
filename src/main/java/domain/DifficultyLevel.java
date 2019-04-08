package domain;

import org.apache.commons.lang3.StringUtils;

public enum DifficultyLevel {
    ADVANCED(10, 0.8),
    INTERMEDIATE(7, 0.6),
    BASIC(4, 0.4);

    private int height;
    private double probability;

    DifficultyLevel(int height, double probability) {
        this.height = height;
        this.probability = probability;
    }

    public Movable generateMovableFrom(Boolean currentMovable) {
        if (currentMovable) {
            return Movable.FALSE;
        }

        if (Math.random() <= probability) {
            return Movable.TRUE;
        }

        return Movable.FALSE;
    }

    public int getHeight() {
        return height;
    }

    public static DifficultyLevel valueFrom(String name) {
        if (StringUtils.equals(name, "상")) {
            return ADVANCED;
        }

        if (StringUtils.equals(name, "중")) {
            return INTERMEDIATE;
        }

        if (StringUtils.equals(name, "하")) {
            return BASIC;
        }

        throw new IllegalArgumentException();
    }
}
