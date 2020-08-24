package nextstep.ladder;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
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
    List<Horizon> ladder = LadderGenerator.generate(players);
    ViewOutput.printLadder(ladder);
  }

  @Test
  void printCenter() {
    assertThat(ViewOutput.center("abc")).isEqualTo("   abc   ");
    assertThat(ViewOutput.center("abcd")).isEqualTo("  abcd   ");
  }

}

