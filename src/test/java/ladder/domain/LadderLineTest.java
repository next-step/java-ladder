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
    List<Boolean> connects = List.of(true, false, false);
    List<Boolean> leftConnectExpect = List.of(false, true, false);
    List<Boolean> rightConnectExpect = List.of(true, false, false);

    LadderPartLine ladderLine = LadderPartLine.of(connects);

    for (int i = 0; i < connects.size(); i++) {
      assertThat(ladderLine.isLeftConnect(i)).isEqualTo(leftConnectExpect.get(i));
      assertThat(ladderLine.isRightConnect(i)).isEqualTo(rightConnectExpect.get(i));
    }
  }
}
