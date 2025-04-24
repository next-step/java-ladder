package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LadderTest {

  @Test
  void testLadderCreatesRightAmountOfHeight() {
    int height = 3;
    Players players = new Players("pobi,crong,jk");

    Ladder ladder = new Ladder(height, players, () -> false, "1, 2, 3");
    String[] lines = ladder.toConsoleOutput().split("\n");

    assertEquals(height, lines.length);
  }

  @Test
  void testLadderCreatesPlayersCounts() {
    int height = 1;
    Players players = new Players("pobi,crong,jk");

    Ladder ladder = new Ladder(height, players, () -> true, "1, 2, 3");
    String rendered = ladder.toConsoleOutput();

    assertThat(rendered).isEqualTo("     |-----|     |");
  }
}