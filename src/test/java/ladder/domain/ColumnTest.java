package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import ladder.exception.OutOfColumnRangeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ColumnTest {

  @DisplayName("value 가 같으면 동등성 비교가 참을 리턴한다 역명제도 성립한다")
  @Test
  public void equals() {
    assertAll("동등성을 검증한다",
        () -> assertThat(Column.of(1))
            .as("숫자가 같으면 동일하다")
            .isEqualTo(Column.of(1)),
        () -> assertThat(Column.of(2))
            .as("숫자가 다르면 동일하지 않다")
            .isNotEqualTo(Column.of(4)),
        () -> assertThat(Column.of(22).isSame(Column.of(22)))
            .as("숫자가 같으면 동일하다")
            .isTrue()
    );
  }

  @DisplayName("범위를 초과한 value 입력시 예외가 발생한다")
  @Test
  public void outOfColumnRangeException() {
    assertThatThrownBy(() -> {
      Column.of(-1);
    }).isInstanceOf(OutOfColumnRangeException.class)
        .hasMessageContaining("사용 가능한 Column 의 범위에서 초과하였습니다");
  }

  @DisplayName("0미만의 value 입력시 예외가 발생한다")
  @Test
  public void outOfColumnRangeExceptionUnderZero() {
    assertThatThrownBy(() -> {
      Column.of(-1);
    }).isInstanceOf(OutOfColumnRangeException.class)
        .hasMessageContaining("사용 가능한 Column 의 범위에서 초과하였습니다");
  }

  @DisplayName("인접한 Column 인지를 판단하는 메서드 isAdjacent() 를 검증한다")
  @Test
  public void isAdjacent() {
    assertAll("동등성을 검증한다",
        () -> assertThat(Column.of(6).isAdjacent(Column.of(7)))
            .as("인접한 Column 은 isAdjacent() 메서드가 True 를 반환한다")
            .isTrue(),
        () -> assertThat(Column.of(7).isAdjacent(Column.of(8)))
            .as("인접한 Column 은 isAdjacent() 메서드가 True 를 반환한다")
            .isTrue(),
        () -> assertThat(Column.of(8).isAdjacent(Column.of(9)))
            .as("인접한 Column 은 isAdjacent() 메서드가 True 를 반환한다")
            .isTrue(),
        () -> assertThat(Column.of(6).isAdjacent(Column.of(8)))
            .as("인접하지 않은 Column 은 isAdjacent() 메서드가 False 를 반환한다")
            .isFalse(),
        () -> assertThat(Column.of(7).isAdjacent(Column.of(9)))
            .as("인접하지 않은 Column 은 isAdjacent() 메서드가 False 를 반환한다")
            .isFalse(),
        () -> assertThat(Column.of(6).isAdjacent(Column.of(9)))
            .as("인접하지 않은 Column 은 isAdjacent() 메서드가 False 를 반환한다")
            .isFalse()
    );
  }
}
