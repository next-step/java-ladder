package nextstep.ladder.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LineTest {

  @Test
  void testCreateLine() {
    Line line = new Line(new Players("pobi,crong,jk"), () -> true);
    String lineRendered = line.toConsoleOutput();

    String[] segments = lineRendered.trim().split("\\|");
    for (int i = 2; i < segments.length; i++) {
      boolean prevHasLine = segments[i - 1].contains("-----");
      boolean currHasLine = segments[i].contains("-----");
      Assertions.assertFalse(prevHasLine && currHasLine, "연속된 가로줄 발견: " + segments[i - 1] + " | " + segments[i]);
    }
  }
}