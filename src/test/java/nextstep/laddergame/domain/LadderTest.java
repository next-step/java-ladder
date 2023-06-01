package nextstep.laddergame.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderTest {

  @DisplayName("사다리 높이(Row 갯수)가 1보다 작으면 예외를 던진다.")
  @Test
  public void ladder_throwException_ifRowLess1() {
    List<Row> rows = new ArrayList<>();
    assertThatThrownBy(() -> new Ladder(rows)).isInstanceOf(IllegalArgumentException.class);
  }
}
