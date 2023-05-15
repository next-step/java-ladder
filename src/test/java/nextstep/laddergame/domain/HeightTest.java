package nextstep.laddergame.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HeightTest {

  @DisplayName("높이는 1보다 작을 수 없다.")
  @Test
  public void height_throwException_ifLessThan1() {
    assertThatThrownBy(() -> new Height(-1)).isInstanceOf(IllegalArgumentException.class);
    assertThatThrownBy(() -> new Height(0)).isInstanceOf(IllegalArgumentException.class);
  }

}
