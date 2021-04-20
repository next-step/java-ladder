package ladder.rule;

@FunctionalInterface
public interface LineRule {
  boolean isDrawing();

  static LineRule drawing() {
    return () -> true;
  }

  static LineRule empty() {
    return () -> false;
  }
}
