package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import ladder.exception.OutOfRowRangeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RowTest {

  @DisplayName("value 가 같으면 동등성 비교가 참을 리턴한다")
  @Test
  public void equals() {
    assertAll("동등성을 검증한다",
        () -> assertThat(Row.of(1)).as("숫자가 같으면 동일하다").isEqualTo(Row.of(1)),
        () -> assertThat(Row.of(2)).as("숫자가 다르면 동일하지 않다").isNotEqualTo(Row.of(4))
    );
  }

  @DisplayName("Preferences 에서 설정한 최대 범위를 초과하면 예외가 발생한다")
  @Test
  public void outOfRowRangeExceptionUnderZero() {
    assertThatThrownBy(() -> {
      Row.of(-1);
    }).isInstanceOf(OutOfRowRangeException.class)
        .hasMessageContaining("사용 가능한 Row 의 범위에서 초과하였습니다");
  }
}
