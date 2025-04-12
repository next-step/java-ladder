package nextstep.ladder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class LadderGameTest {

  @Test
  void testCreatePlayer() {
    String playerName = "pobi";

    Player player = new Player(playerName);

    assertThat(player).isEqualTo(new Player(playerName));
  }

  @Test
  void testCreatePlayerWithLongerThan5LetterName() {
    String playerName = "pobi123";

    assertThatThrownBy(() -> new Player(playerName))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("이름은 5자 이하여야 합니다.");
  }

  @Test
  void testCreateLine() {
    Line line = new Line(10, () -> true);
    String lineRendered = line.toConsoleOutput();

    String[] segments = lineRendered.trim().split("\\|");
    for (int i = 2; i < segments.length; i++) {
      boolean prevHasLine = segments[i - 1].contains("-----");
      boolean currHasLine = segments[i].contains("-----");
      assertFalse(prevHasLine && currHasLine, "연속된 가로줄 발견: " + segments[i - 1] + " | " + segments[i]);
    }
  }

  @Test
  void testLadderCreatesRightAmountOfHeight() {
    int height = 3;
    int players = 4;

    Ladder ladder = new Ladder(height, players, () -> false);

    String[] lines = ladder.toConsoleOutput().split("\n");
    assertEquals(height, lines.length);
  }

  @Test
  void testLadderCreatesPlayersCounts() {
    int height = 1;
    int players = 5;

    Ladder ladder = new Ladder(height, players, () -> true);

    String rendered = ladder.toConsoleOutput();
    long count = rendered.chars().filter(c -> c == '|').count();
    assertEquals(players*height, count);
  }
}
