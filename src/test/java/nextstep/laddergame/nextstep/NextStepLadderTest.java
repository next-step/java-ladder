package nextstep.laddergame.nextstep;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import nextstep.laddergame.engine.Row;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NextStepLadderTest {

  @DisplayName("사다리 높이(Row 갯수)가 1보다 작으면 예외를 던진다.")
  @Test
  public void ladder_throwException_ifRowLess1() {
    List<Row> rows = new ArrayList<>();
    assertThatThrownBy(() -> new NextStepLadder(rows)).isInstanceOf(IllegalArgumentException.class);
  }
}
