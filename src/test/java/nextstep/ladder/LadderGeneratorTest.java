package nextstep.ladder;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class LadderGeneratorTest {

  @Test
  void create() {
    assertThat(LadderGenerator
        .generate(Players.valueOf("make,some,noise", 4)).size())
        .as("사다리 높이")
        .isEqualTo(4);
  }

  @Test
  void createAsLadder() {
    assertThat(LadderGenerator
        .generateLadder(Players.valueOf("make,some,noise", 4)).getHorizons().size())
        .as("사다리 높이")
        .isEqualTo(4);
  }

  @Test
  void renderFor3Person() {
    List<Horizon> ladder = LadderGenerator
        .generate(Players.valueOf("make,some,noise", 4));

    for (Horizon horizon : ladder) {
      System.out.println(horizon);
    }
  }


  @Test
  void renderFor3PersonAsLadder() {
    Ladder ladder = LadderGenerator
        .generateLadder(Players.valueOf("make,some,noise", 4));

    ladder.getHorizons().stream()
        .forEach(System.out::println);
  }

  @Test
  void renderFor5Person() {
    List<Horizon> ladder = LadderGenerator
        .generate(Players.valueOf("player1,player2,player3,player4,player5", 4));

    for (Horizon horizon : ladder) {
      System.out.println(horizon);
    }
  }

  @Test
  void renderFor5PersonAsLadder() {
    Ladder ladder = LadderGenerator
        .generateLadder(Players.valueOf("player1,player2,player3,player4,player5", 4));

    ladder.getHorizons().stream()
        .forEach(System.out::println);
  }
}
