package nextstep.fp;

@FunctionalInterface
public interface Conditional<T> {
    boolean isCondition(T t);
}
