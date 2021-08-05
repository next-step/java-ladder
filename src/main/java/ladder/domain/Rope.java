package ladder.domain;

import java.util.Objects;
import java.util.Random;

public class Rope {
    private static final Random random = new Random();

    private final boolean value;

    private Rope(boolean value) {
        this.value = value;
    }

    public static Rope of(Boolean value) {
        return value ? InnerLazyClass.PRESENT : InnerLazyClass.EMPTY;
    }

    public static Rope present() {
        return InnerLazyClass.PRESENT;
    }

    public static Rope empty() {
        return InnerLazyClass.EMPTY;
    }

    public boolean isPresent() {
        return value;
    }

    public Rope next() {
        if (this.equals(present()))
            return empty();
        return of(random.nextBoolean());
    }

    @Override
    public boolean equals(Object compareValue) {
        if (this == compareValue) return true;
        if (compareValue == null || getClass() != compareValue.getClass()) return false;
        Rope rope = (Rope) compareValue;
        return value == rope.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    private static class InnerLazyClass {
        private static Rope PRESENT = new Rope(true);
        private static Rope EMPTY = new Rope(false);
    }
}
