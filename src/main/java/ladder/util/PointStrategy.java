package ladder.util;

@FunctionalInterface
public interface PointStrategy {

    boolean point();

    default boolean injectFalse() {
        return false;
    }

    default boolean injectTrue() {
        return true;
    }
}
