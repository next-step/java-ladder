package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderPartTest {

  @Test
  @DisplayName("공백 생성자를 통해 LadderPart가 잘 생성되는지 확인")
  void from() {
    LadderPart ladderPart = new LadderPart();
    assertThat(ladderPart).usingRecursiveComparison().isEqualTo(new LadderPart());
  }

  @Test
  @DisplayName("연결 메서드를 통해 LadderPart 끼리 연결되는 것을 확인")
  void connect(){
    LadderPart ladderPartLeft = new LadderPart();
    LadderPart ladderPartRight = new LadderPart();
    ladderPartLeft.connectRight();
    ladderPartRight.connectLeft();

    assertThat(ladderPartLeft.isLeftConnect()).isFalse();
    assertThat(ladderPartLeft.isRightConnect()).isTrue();
    assertThat(ladderPartRight.isLeftConnect()).isTrue();
    assertThat(ladderPartRight.isRightConnect()).isFalse();
  }


}
