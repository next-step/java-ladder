package nextstep.ladder;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class ViewOutputTest {

  @Test
  void printPlayers() {
    Players players = Players.valueOf(Arrays.asList("make", "some", "noise"), 1);
    ViewOutput.printPlayers(players);
  }

  @Test
  void printLadder() {
    Players players = Players.valueOf(Arrays.asList("make", "some"), 1);
    Ladder ladder = LadderGenerator.generate(players);
    ViewOutput.printLadder(ladder);
  }

  @Test
  void printCenter() {
    assertThat(ViewOutput.center("abc")).isEqualTo("   abc   ");
    assertThat(ViewOutput.center("abcd")).isEqualTo("  abcd   ");
  }

}
