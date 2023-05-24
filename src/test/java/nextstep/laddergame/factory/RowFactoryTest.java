package nextstep.laddergame.factory;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import nextstep.laddergame.domain.Row;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RowFactoryTest {

  @DisplayName("Line이 겹치도록 Row가 생성된다면 Exception을 던진다.")
  @Test
  public void createRow_throwException_ifTwoWayPoint() {
    assertThatThrownBy(() -> RowFactory.createRow(5, (p1, p2) -> true))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("넓이가 1미만인 Row는 생성할 수 없다.")
  @ParameterizedTest
  @ValueSource(ints = {0, -1, -2, -10})
  public void createRow_throwException_ifLessThan1(int input) {
    assertThatThrownBy(() -> RowFactory.createRow(input, (p1, p2) -> false))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("넓이만큼의 Point수를 갖는 Row를 생성한다.")
  @ParameterizedTest
  @ValueSource(ints = {1, 2, 3, 10})
  public void createRow(int input) {
    Row row = RowFactory.createRow(input, (p1, p2) -> false);

    assertThat(row.getPoints().size()).isEqualTo(input);
  }
}
