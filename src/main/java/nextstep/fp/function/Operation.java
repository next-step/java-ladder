package nextstep.fp.function;

@FunctionalInterface
public interface Operation {
  int formula(int a, int b);

  static Operation add() {
    return (a, b) -> a + b;
  }
}
