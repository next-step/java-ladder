package nextstep.ladder.view;

@FunctionalInterface
public interface Formatter<T> {
    String format(T target);
}
