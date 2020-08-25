package nextstep.ladder.biz;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class LadderGeneratorTest {

  @Test
  void createAsLadder() {
    assertThat(LadderGenerator.generate(3, 4).ladderHeight())
        .as("사다리 높이")
        .isEqualTo(4);
  }

  @Test
  void renderFor3PersonAsLadder() {
    Ladder ladder = LadderGenerator.generate(3, 4);

    ladder.getLines().stream()
        .forEach(System.out::println);
  }

  @Test
  void renderFor5PersonAsLadder() {
    Ladder ladder = LadderGenerator.generate(10, 4);

    ladder.getLines().stream()
        .forEach(System.out::println);
  }
}
