package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderLineTest {

  @Test
  @DisplayName("연결 전략을 통해 LadderLine 이 잘 생성되는지 확인")
  void of() {
    List<Boolean> connects = List.of(true, false, false);
    LadderPartLine ladderLine = LadderPartLine.of(connects);
    assertThat(ladderLine).usingRecursiveComparison().isEqualTo(LadderPartLine.of(connects));
  }

  @Test
  @DisplayName("해당 좌표 연결/비연결 여부 확인")
  void isConnect() {
    LadderPartLine ladderLine = LadderPartLine.of(List.of(true, false, false));
    assertThat(ladderLine.isLeftConnect(0)).isFalse();
    assertThat(ladderLine.isRightConnect(0)).isTrue();
    assertThat(ladderLine.isLeftConnect(1)).isTrue();
    assertThat(ladderLine.isRightConnect(1)).isFalse();
    assertThat(ladderLine.isLeftConnect(2)).isFalse();
    assertThat(ladderLine.isRightConnect(2)).isFalse();
  }
}
