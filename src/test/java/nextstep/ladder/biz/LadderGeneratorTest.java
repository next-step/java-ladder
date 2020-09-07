package nextstep.ladder.biz;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGeneratorTest {

  private Ladder ladder;

  @BeforeEach
  void setUp() {
    ladder = LadderGenerator.generate(3, 4);
  }

  @Test
  void given4Height_whenCreate_thenHeightIs4() {
    assertThat(ladder.ladderHeight())
        .as("사다리 높이")
        .isEqualTo(4);
  }

  @Test
  void given3Person_whenCreate_thenPointIs2() {
    ladder.getLines().stream()
        .forEach(line -> assertThat(line.getPoints().size())
            .as("사다리 폭")
            .isEqualTo(2));
  }

  @Test
  void renderFor3PersonAsLadder() {
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
