package nextstep.ladder;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderGeneratorTest {

  @Test
  @DisplayName("입력받은 가로-1, 세로 높이 크기의 사다리가 생성된다.")
  void generate_ladder() {
    Ladder ladder = LadderGenerator.generate(5, 6);

    assertThat(ladder.height()).isEqualTo(6);
    assertThat(ladder.width()).isEqualTo(4); // 5명 → 4개의 가로 연결점
  }

}
