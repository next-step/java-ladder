package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static ladder.domain.LadderLine.INVALID_LADDER_LINE_RULE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderLineTest {

  @Test
  @DisplayName("사다리 라인 정보를 입력하여 " +
      "LadderLine을 생성할 수 있으며" +
      "사다리 라인이 정상적으로 생성되는지 검증")
  void ladderLineTest() {
    List<Boolean> given = List.of(true, false, false, true, false);
    LadderLine ladderLine = new LadderLine(given);

    assertThat(ladderLine.isTrue(0)).isEqualTo(true);
    assertThat(ladderLine.isTrue(1)).isEqualTo(false);
    assertThat(ladderLine.isTrue(2)).isEqualTo(false);
    assertThat(ladderLine.isTrue(3)).isEqualTo(true);
    assertThat(ladderLine.isTrue(4)).isEqualTo(false);
  }

  @Test
  @DisplayName("사다리 라인 정보를 입력하여 " +
      "LadderLine을 생성 시" +
      "라인이 겹치는 경우 exception 테스트")
  void ladderLineTest2() {
    List<Boolean> given = List.of(true, false, true, true, false);
    assertThatThrownBy(() -> new LadderLine(given))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining(String.format(INVALID_LADDER_LINE_RULE, given));
  }
}
