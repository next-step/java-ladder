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

  @Test
  void testLadderMove() {
    int height = 1;
    Players players = new Players("pobi,crong,jk");
    Ladder ladder = new Ladder(height, players, () -> true, "1, 2, 3");

    assertEquals(1, ladder.move(0));
    assertEquals(0, ladder.move(1));
    assertEquals(2, ladder.move(2));
  }

  @Test
  void testCreateLadderWithDifferentPlayerAndResultCount() {
    int height = 1;
    Players players = new Players("pobi,crong,jk");
    String results = "1, 2, 3, 4";

    try {
      new Ladder(height, players, () -> true, results);
    } catch (IllegalArgumentException e) {
      assertThat(e.getMessage()).isEqualTo("결과 수는 플레이어 수와 일치해야 합니다.");
    }
  }

  @Test
  void testResultAt() {
    int height = 1;
    Players players = new Players("pobi,crong,jk");
    Ladder ladder = new Ladder(height, players, () -> true, "1, 2, 3");

    assertEquals("1", ladder.resultAt(0));
    assertEquals("2", ladder.resultAt(1));
    assertEquals("3", ladder.resultAt(2));
  }

  @Test
  void testLadderResultsOutput() {
    int height = 1;
    Players players = new Players("pobi,crong,jk");
    Ladder ladder = new Ladder(height, players, () -> true, "1, 2, 3");

    String resultsOutput = ladder.resultsOutput();

    assertThat(resultsOutput).isEqualTo("    1    2    3");
  }
}