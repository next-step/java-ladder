package nextstep.fp;

@FunctionalInterface
public interface Filter<T> {
    boolean filter(T t);
}
