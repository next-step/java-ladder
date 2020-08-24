package nextstep.ladder;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class LadderGeneratorTest {

  @Test
  void createAsLadder() {
    assertThat(LadderGenerator
        .generate(Players.valueOf("make,some,noise", 4)).getHorizons().size())
        .as("사다리 높이")
        .isEqualTo(4);
  }

  @Test
  void renderFor3PersonAsLadder() {
    Ladder ladder = LadderGenerator
        .generate(Players.valueOf("make,some,noise", 4));

    ladder.getHorizons().stream()
        .forEach(System.out::println);
  }

  @Test
  void renderFor5PersonAsLadder() {
    Ladder ladder = LadderGenerator
        .generate(Players.valueOf("player1,player2,player3,player4,player5", 4));

    ladder.getHorizons().stream()
        .forEach(System.out::println);
  }
}
