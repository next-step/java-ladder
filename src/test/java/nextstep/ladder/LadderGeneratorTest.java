package nextstep.ladder;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderGeneratorTest {

  @Test
  @DisplayName("입력받은 가로, 세로 높이 크기의 사다리가 생성된다.")
  void generate_ladder() {
    Ladder ladder = LadderGenerator.generate(5, 4);
    assertThat(ladder.lines()).hasSize(4);
    assertThat(ladder.lines().get(0).points()).hasSize(5);
  }

}
