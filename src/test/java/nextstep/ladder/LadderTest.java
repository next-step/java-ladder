package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Players;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LadderTest {

  @Test
  void testLadderCreatesRightAmountOfHeight() {
    int height = 3;
    Players players = new Players("pobi,crong,jk");

    Ladder ladder = new Ladder(height, players, () -> false);

    String[] lines = ladder.toConsoleOutput().split("\n");
    Assertions.assertEquals(height, lines.length);
  }

  @Test
  void testLadderCreatesPlayersCounts() {
    int height = 1;
    Players players = new Players("pobi,crong,jk");

    Ladder ladder = new Ladder(height, players, () -> true);

    String rendered = ladder.toConsoleOutput();
    long count = rendered.chars().filter(c -> c == '|').count();
    Assertions.assertEquals(players.size() * height, count);
  }
}