package nextstep.fp;

@FunctionalInterface
public interface Conditional<T> {
    boolean test(T number);
}
