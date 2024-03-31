package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static ladder.domain.LadderLine.*;
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

    assertThat(ladderLine.printLine(0)).isEqualTo(PRINT_LINE);
    assertThat(ladderLine.printLine(1)).isEqualTo(EMPTY_LINE);
    assertThat(ladderLine.printLine(2)).isEqualTo(EMPTY_LINE);
    assertThat(ladderLine.printLine(3)).isEqualTo(PRINT_LINE);
    assertThat(ladderLine.printLine(4)).isEqualTo(EMPTY_LINE);
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
