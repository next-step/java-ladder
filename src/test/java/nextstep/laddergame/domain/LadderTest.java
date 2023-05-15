package nextstep.laddergame.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderTest {

  @DisplayName("사다리는 입력받은 높이 만큼의 Row를 갖는다.")
  @Test
  public void ladder_throwException_ifNotEqualHeightAndRowsSize() {
    Height height = new Height(2);
    List<Row> rows = new ArrayList<>();

    assertThatThrownBy(() -> new Ladder(rows, height)).isInstanceOf(IllegalArgumentException.class);
  }

}
