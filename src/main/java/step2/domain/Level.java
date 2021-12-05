package step2.domain;

import java.util.Objects;

public class Level {
    private static final int START_LEVEL = 0;

    private int level;

    private Level() {
        this.level = START_LEVEL;
    }

    private Level(int level) {
        this.level = level;
    }

    public static Level init() {
        return new Level();
    }

    public static Level of(int level) {
        return new Level(level);
    }

    public int level() {
        return level;
    }

    public void next() {
        level++;
    }

    public boolean matched(Level level) {
        return this.equals(level);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Level level1 = (Level) o;
        return level == level1.level;
    }

    @Override
    public int hashCode() {
        return Objects.hash(level);
    }
}
