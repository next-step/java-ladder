package nextstep.fp.function;

@FunctionalInterface
public interface Conditional<T> {
  boolean test(T t);

  static <T> Conditional<T> alwaysTrue() {
    return any -> true;
  }
}
