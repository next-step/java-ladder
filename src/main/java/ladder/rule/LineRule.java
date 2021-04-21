package ladder.rule;

import java.util.Random;

@FunctionalInterface
public interface LineRule {
  int MAX_NUMBER = 2;
  int DRAWING_NUMBER = 1;

  boolean isDrawing();

  static LineRule drawing() {
    return () -> true;
  }

  static LineRule empty() {
    return () -> false;
  }

  static LineRule random() {
    return () -> DRAWING_NUMBER == new Random().nextInt(MAX_NUMBER);
  }
}
