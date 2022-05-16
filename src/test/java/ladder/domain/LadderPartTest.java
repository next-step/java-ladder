package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderPartTest {

  @Test
  @DisplayName("왼쪽,오른족 연결여부를 통해 LadderPart가 잘 생성되는지 확인")
  void from() {
    LadderPart ladderPart = new LadderPart(true, false);
    assertThat(ladderPart).usingRecursiveComparison().isEqualTo(new LadderPart(true, false));
    assertThat(ladderPart).usingRecursiveComparison().isNotEqualTo(new LadderPart(false, true));
  }

  @Test
  @DisplayName("메서드를 통해 LadderPart 연결여부 확인")
  void connect() {
    LadderPart ladderPartLeft = new LadderPart(true, false);
    LadderPart ladderPartRight = new LadderPart(false, true);

    assertThat(ladderPartLeft.isLeftConnect()).isTrue();
    assertThat(ladderPartLeft.isRightConnect()).isFalse();
    assertThat(ladderPartRight.isLeftConnect()).isFalse();
    assertThat(ladderPartRight.isRightConnect()).isTrue();
  }


}
