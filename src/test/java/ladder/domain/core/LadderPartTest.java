package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LadderPartTest {

  @ParameterizedTest
  @DisplayName("연결된 다음 파트의 인덱스를 잘 가져오는지 확인")
  @CsvSource(value = {"LEFT|0", "RIGHT|2", "NONE|1"}, delimiter = '|')
  void nextIndex(Connect connect, int expect) {
    LadderPart ladderPart = LadderPart.of(1, connect);
    assertThat(ladderPart.move()).isEqualTo(expect);
  }

  @Test
  @DisplayName("첫 파트를 잘 생성하는지 확인")
  void first() {
    LadderPart first = LadderPart.first();
    assertThat(first).isIn(LadderPart.of(0, Connect.RIGHT), LadderPart.of(0, Connect.NONE));
  }

  @Test
  @DisplayName("다음 파트를 연속된 연결 없이 잘 생성하는지 확인")
  void generateNext() {
    LadderPart part = LadderPart.first();
    for (int i = 0; i < 100; i++) {
      part = part.generateNext();
    }
  }
}
