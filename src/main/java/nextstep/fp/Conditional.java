package nextstep.fp;

@FunctionalInterface
public interface Conditional<T> {
    boolean matches(T t);
}
